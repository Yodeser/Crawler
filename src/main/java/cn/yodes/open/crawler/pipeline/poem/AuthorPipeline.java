package cn.yodes.open.crawler.pipeline.poem;

import cn.yodes.open.crawler.domain.AuthorEntity;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

/**
 * <pre>
 * <p>Description: //TODO</p>
 * <p>Copyright (c) 2017 open.yodes.cn Inc. All rights reserved.</p>
 * </pre>
 *
 * @author Yodes Yang
 * @created 2018/3/29 19:52
 */
public class AuthorPipeline implements Pipeline {
    private AuthorEntity author;

    @Override
    public void process(ResultItems resultItems, Task task) {
        author = resultItems.get("author");
    }

    public AuthorEntity getAuthor() {
        return this.author;
    }
}
