package cn.yodes.open.crawler.web;

import cn.yodes.open.crawler.pipeline.poem.FilePipeline;
import cn.yodes.open.crawler.processor.poem.PoemProcessor;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.downloader.HttpClientDownloader;
import us.codecraft.webmagic.selector.Html;

/**
 * <pre>
 * <p>Description: //TODO</p>
 * </pre>
 *
 * @author Yodes Yang
 * @since 2018/3/29 14:52
 */
public class PoemsCrawler {

    public static void main(String[] args) {
        HttpClientDownloader httpClientDownloader = new HttpClientDownloader();
        String startUrl = "http://www.shicimingju.com/chaxun/zuozhe/29.html";

        Html html = httpClientDownloader.download(startUrl);
        PoemProcessor processor = new PoemProcessor();
        String[] urlList = html.xpath("//*/div[@class='pagination www-shadow-card']")
                .links()
                .all()
                .toArray(args);
        Spider.create(processor).addUrl(startUrl).addUrl(urlList)
                .addPipeline(new FilePipeline()).run();
    }
}