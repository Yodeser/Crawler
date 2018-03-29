package cn.yodes.open.crawler.poems.pipeline;

import cn.yodes.open.crawler.poems.domain.PoemEntity;
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

    @Override
    public void process(ResultItems resultItems, Task task) {
        PoemEntity poemEntity = new PoemEntity();
        poemEntity.setTitle(resultItems.get("title"));
        poemEntity.setDynasty(resultItems.get("dynasty"));
        poemEntity.setAuthor(resultItems.get("author"));
        poemEntity.setContent(resultItems.get("content"));
        poemEntity.setTags(resultItems.get("tags"));
        poemEntity.setAppreciation(resultItems.get("appreciation"));
        System.out.println(poemEntity.toString());
    }
}
