package cn.yodes.open.crawler.poems.pipeline;

import cn.yodes.open.crawler.poems.domain.PoemEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

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
    Logger log = LoggerFactory.getLogger(FilePipeline.class);

    @Override
    public void process(ResultItems resultItems, Task task) {
        PoemEntity poemEntity = new PoemEntity();
        poemEntity.setTitle(resultItems.get("title").toString());
        poemEntity.setDynasty(resultItems.get("dynasty").toString());
        poemEntity.setAuthor(resultItems.get("author").toString());
        poemEntity.setContent(resultItems.get("content").toString());
        poemEntity.setTags(resultItems.get("tags"));
        poemEntity.setAppreciation(resultItems.get("appreciation").toString());
        log.info(poemEntity.toString());
    }
}
