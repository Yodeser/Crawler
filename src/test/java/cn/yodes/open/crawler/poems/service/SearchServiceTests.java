package cn.yodes.open.crawler.poems.service;

import cn.yodes.open.crawler.poems.pipeline.AuthorPipeline;
import cn.yodes.open.crawler.poems.processor.AuthorProcessor;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.pipeline.ResultItemsCollectorPipeline;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

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
    private Logger log = LoggerFactory.getLogger(SearchServiceTests.class);

    @Test
    public void searchAuthor() {
        Request request = new SearchService().searchAuthor("李白");
        AuthorPipeline authorPipeline = new AuthorPipeline();
        Spider spider = Spider.create(new AuthorProcessor()).addRequest(request).addPipeline(authorPipeline).thread(5);
        spider.run();
        log.info(authorPipeline.getAuthor().toString());
    }
}
