package cn.yodes.open.crawler.web;

import cn.yodes.open.crawler.pipeline.music.MusicPipeline;
import cn.yodes.open.crawler.processor.music.MusicProcessor;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import us.codecraft.webmagic.Spider;

import java.io.File;
import java.io.IOException;

/**
 * <pre>
 * <p>Description: //TODO</p>
 * <p>Copyright (c) 2018 open.yodes.cn Inc. All rights reserved.</p>
 * </pre>
 *
 * @author Yodes Yang
 * @since 2018/4/10
 */
public class MusicCrawler {
    private static Logger log = LoggerFactory.getLogger(MusicCrawler.class);

    public static void main(String[] args) throws IOException {
        MusicProcessor musicProcessor = new MusicProcessor();
        MusicPipeline musicPipeline = new MusicPipeline();
        String baseUrl = "http://www.xiami.com/genre/songs/sid/3341/page/";
        int pageSum = 17;
        String[] urlList = new String[pageSum];
        for (int i = 1; i <= pageSum; i++) {
            urlList[i - 1] = baseUrl + i;
        }

        Long startTime = System.currentTimeMillis();
        Spider.create(musicProcessor).addUrl(urlList)
                .addPipeline(musicPipeline).thread(30).run();

        log.info("共耗时： {} ms", System.currentTimeMillis() - startTime);
        FileUtils.writeStringToFile(new File("C:\\Users\\Administrator\\Desktop\\Spider\\Music\\Hip-Hop\\all_irc.txt")
                , musicPipeline.getIrcStr(), "utf8");
    }
}
