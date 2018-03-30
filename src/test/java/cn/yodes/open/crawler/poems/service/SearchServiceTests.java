package cn.yodes.open.crawler.poems.service;

import cn.yodes.open.crawler.poems.processor.AuthorProcessor;
import org.junit.Test;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;

/**
 * <pre>
 * <p>Description: //TODO</p>
 * <p>Copyright (c) 2018 open.yodes.cn Inc. All rights reserved.</p>
 * </pre>
 *
 * @author Yodes Yang
 * @since 2018/3/29 14:58
 */
public class SearchServiceTests {
    @Test
    public void searchAuthor() {
        Request request = new SearchService().searchAuthor("李白");
        Spider.create(new AuthorProcessor()).addRequest(request).addPipeline(new ConsolePipeline()).thread(5).run();
    }
}
