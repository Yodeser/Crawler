package cn.yodes.open.crawler.service;

import cn.yodes.open.crawler.pipeline.music.MultiFilePipeline;
import cn.yodes.open.crawler.pipeline.music.MusicPipeline;
import cn.yodes.open.crawler.processor.music.MusicProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.downloader.HttpClientDownloader;
import us.codecraft.webmagic.selector.Html;
import us.codecraft.webmagic.selector.JsonPathSelector;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * <pre>
 * <p>Description: //TODO</p>
 * <p>Copyright (c) 2018 open.yodes.cn Inc. All rights reserved.</p>
 * </pre>
 *
 * @author Yodes Yang
 * @since 2018/4/10
 */
public class MusicService {
    private static Logger log = LoggerFactory.getLogger(MusicService.class);

    public void searchSongs() throws IOException {
        String[] urlArr = listSongsUrl();

        MusicProcessor musicProcessor = new MusicProcessor();
        MusicPipeline musicPipeline = new MusicPipeline();
        MultiFilePipeline multiFilePipeline = new MultiFilePipeline();
//        String baseUrl = "http://www.xiami.com/genre/songs/sid/3341/page/";
//        int pageSum = 17;
//        String[] urlList = new String[pageSum];
//        for (int i = 1; i <= pageSum; i++) {
//            urlList[i - 1] = baseUrl + i;
//        }

        Long startTime = System.currentTimeMillis();
        Spider.create(musicProcessor).addUrl(urlArr)
                .addPipeline(multiFilePipeline).thread(30).run();

        log.info("共耗时： {} ms", System.currentTimeMillis() - startTime);
//        FileUtils.writeStringToFile(new File("C:\\Users\\Administrator\\Desktop\\Spider\\Music\\Hip-Hop\\all_irc.txt")
//                , musicPipeline.getIrcStr(), "utf8");
    }

    public String[] listSongsUrl() {
        String songSetUrl_1 = "http://www.xiami.com/collect/ajax-get-list?_=1523347028187&id=386405768&p=";
        String songSetUrl_2 = "http://www.xiami.com/collect/ajax-get-list?_=1523349272785&id=386386842&p=";

        List<String> songUrlList = new ArrayList<>();
        for (int i = 1; i <= 40; i++) {
            songUrlList.addAll(analysisAjax(songSetUrl_1 + i));
        }
        for (int j = 1; j <= 31; j++) {
            songUrlList.addAll(analysisAjax(songSetUrl_2 + j));
        }

        return songUrlList.toArray(new String[]{});
    }

    public List<String> analysisAjax(String url) {
        HttpClientDownloader httpClientDownloader = new HttpClientDownloader();
        Html html = httpClientDownloader.download(url);
        String songsBase = "http://www.xiami.com/song/";
        JsonPathSelector stateSelector = new JsonPathSelector("$.result.total_page");
        JsonPathSelector songsSelector = new JsonPathSelector("$.result.data[*].song_id");

        List<String> resultList = new ArrayList<>();
        try {
//            log.info(stateSelector.select(html.getDocument().body().text()));
            resultList = songsSelector.selectList(html.getDocument().body().text());
        } catch (Exception e) {
            log.warn(url);
        }
        return resultList.stream().map(s -> songsBase + s).collect(toList());
    }

    public static void main(String[] args) throws IOException {
//        String[] arr = new MusicService().listSongsUrl();
//        Arrays.stream(arr).forEach(log::info);
//        log.info(arr.length + "");
        new MusicService().searchSongs();
    }
}
