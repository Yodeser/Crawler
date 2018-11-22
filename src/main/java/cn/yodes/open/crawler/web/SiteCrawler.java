package cn.yodes.open.crawler.web;

import cn.yodes.open.crawler.pipeline.game.SitePipeline;
import cn.yodes.open.crawler.processor.game.SiteProcessor;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.downloader.HttpClientDownloader;
import us.codecraft.webmagic.selector.Html;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * <p>Description: //TODO</p>
 * <p>Copyright (c) 2018 yodes.cn Inc. All rights reserved.</p>
 * </pre>
 *
 * @author Yodes Yang
 * @since 2018/11/19
 */
public class SiteCrawler {
    public static void main(String[] args) {
        String startUrl = "http://www.18183.com/zqgamelist/index.html";
        HttpClientDownloader httpClientDownloader = new HttpClientDownloader();

        Html html = httpClientDownloader.download(startUrl);
        String[] urlList = html.xpath("//*/div[@class='cov']/div/a[1]")
                .links()
                .all()
                .toArray(args);
        List<String> lists = new ArrayList<>();
        for (String url : urlList) {
            lists.add(url + "news/");
            lists.add(url + "gonglue/");
        }

        SiteProcessor processor = new SiteProcessor();
        Spider.create(processor).addUrl(startUrl).addUrl(lists.toArray(args)).thread(10)
                .addPipeline(new SitePipeline()).run();
    }
}
