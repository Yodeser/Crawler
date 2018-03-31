package cn.yodes.open.crawler.poems.web;

import cn.yodes.open.crawler.poems.pipeline.FilePipeline;
import cn.yodes.open.crawler.poems.processor.PoemProcessor;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.downloader.HttpClientDownloader;
import us.codecraft.webmagic.model.HttpRequestBody;
import us.codecraft.webmagic.model.annotation.ExtractBy;
import us.codecraft.webmagic.model.annotation.TargetUrl;
import us.codecraft.webmagic.selector.Html;
import us.codecraft.webmagic.utils.HttpClientUtils;

import java.util.List;

/**
 * <pre>
 * <p>Description: //TODO</p>
 * <p>Copyright (c) 2018 www.oppo.com Inc. All rights reserved.</p>
 * <p>Company: OPPO</p>
 * </pre>
 *
 * @author Yangxingji
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