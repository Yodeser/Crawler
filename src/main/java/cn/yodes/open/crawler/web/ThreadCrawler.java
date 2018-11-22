package cn.yodes.open.crawler.web;

import cn.yodes.open.crawler.pipeline.game.ThreadPipeline;
import cn.yodes.open.crawler.processor.game.ThreadProcessor;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import us.codecraft.webmagic.Spider;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * <pre>
 * <p>Description: //TODO</p>
 * <p>Copyright (c) 2018 yodes.cn Inc. All rights reserved.</p>
 * </pre>
 *
 * @author Yodes Yang
 * @since 2018/11/20
 */
@Service
public class ThreadCrawler {
    @Autowired
    private ThreadPipeline threadPipeline;

    public void start() throws IOException {
        List<String> urlList = FileUtils.readLines(new File(System.getProperty("user.dir") + "/data/siteUrls.txt"),"utf8");
        ThreadProcessor processor = new ThreadProcessor();
        Spider.create(processor).addUrl(urlList.toArray(new String[]{})).thread(5)
                .addPipeline(threadPipeline).run();
    }
}
