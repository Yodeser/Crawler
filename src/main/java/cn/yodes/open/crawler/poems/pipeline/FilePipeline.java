package cn.yodes.open.crawler.poems.pipeline;

import cn.yodes.open.crawler.poems.domain.PoemEntity;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.io.File;
import java.io.IOException;

/**
 * <pre>
 * <p>Description: //TODO</p>
 * <p>Copyright (c) 2018 open.yodes.cn Inc. All rights reserved.</p>
 * </pre>
 *
 * @author Yodes Yang
 * @since 2018/3/29 14:58
 */
public class FilePipeline implements Pipeline {
    private Logger log = LoggerFactory.getLogger(FilePipeline.class);

    @Override
    public void process(ResultItems resultItems, Task task) {
        PoemEntity poemEntity = resultItems.get("poem");
        File file = new File("C:\\Users\\Administrator\\Desktop\\Poems\\" + poemEntity.getDynasty() + "\\" + poemEntity.getAuthor() + "\\" + poemEntity.getTitle() + ".txt");
        if (file.exists()) {
            file = new File(file.getPath().replace(".txt", "") + "_" + poemEntity.getContent().split(",")[0].substring(0, 3) + ".txt");
        }
        StringBuilder outputBuilder = new StringBuilder();
        outputBuilder.append(poemEntity.getContent());
        try {
            FileUtils.writeStringToFile(file, outputBuilder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        log.info("SUCCESS - title: {} - author: {}", poemEntity.getTitle(), poemEntity.getAuthor());
    }
}
