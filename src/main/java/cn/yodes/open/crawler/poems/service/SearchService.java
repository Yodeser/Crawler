package cn.yodes.open.crawler.poems.service;

import cn.yodes.open.crawler.poems.domain.AuthorEntity;
import cn.yodes.open.crawler.poems.pipeline.AuthorPipeline;
import cn.yodes.open.crawler.poems.pipeline.FilePipeline;
import cn.yodes.open.crawler.poems.processor.AuthorProcessor;
import cn.yodes.open.crawler.poems.processor.PoemProcessor;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.downloader.HttpClientDownloader;
import us.codecraft.webmagic.model.HttpRequestBody;
import us.codecraft.webmagic.pipeline.ResultItemsCollectorPipeline;
import us.codecraft.webmagic.selector.Html;
import us.codecraft.webmagic.utils.HttpConstant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <pre>
 * <p>Description: //TODO</p>
 * <p>Copyright (c) 2018 open.yodes.cn Inc. All rights reserved.</p>
 * </pre>
 *
 * @author Yodes Yang
 * @since 2018/3/29 14:58
 */
public class SearchService {
    private Logger log = LoggerFactory.getLogger(SearchService.class);

    public void searchAuthor(String authorName) {
        Request request = new Request("http://www.shicimingju.com/webApi/ajaxSearch");
        request.setCharset("utf-8");
        request.setMethod(HttpConstant.Method.POST);
        request.addHeader("Content-Type", HttpRequestBody.ContentType.FORM);
        request.addHeader("X-Requested-With", "xmlhttprequest");

        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("kw", authorName);
        dataMap.put("position", "0");
        request.setRequestBody(HttpRequestBody.form(dataMap, "utf-8"));

        AuthorPipeline authorPipeline = new AuthorPipeline();
        Spider spider = Spider.create(new AuthorProcessor()).addRequest(request).addPipeline(authorPipeline).thread(5);
        spider.run();
        AuthorEntity author = authorPipeline.getAuthor();

        HttpClientDownloader httpClientDownloader = new HttpClientDownloader();
        String startUrl = "http://www.shicimingju.com/chaxun/zuozhe/" + author.getId() + ".html";
        Html html = httpClientDownloader.download(startUrl);
        PoemProcessor processor = new PoemProcessor();
        String[] urlList = html.xpath("//*/div[@class='pagination www-shadow-card']")
                .links()
                .all()
                .toArray(new String[]{});
        Spider.create(processor).addUrl(startUrl).addUrl(urlList)
                .addPipeline(new FilePipeline()).run();
    }
}
