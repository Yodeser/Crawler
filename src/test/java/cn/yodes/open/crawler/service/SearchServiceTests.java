package cn.yodes.open.crawler.service;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
        new SearchService().searchAuthor("李白");
    }
}
