package cn.yodes.open.crawler.pipeline.game;

import cn.yodes.open.crawler.dal.ThreadDao;
import cn.yodes.open.crawler.domain.ThreadEntity;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.List;

/**
 * <pre>
 * <p>Description: //TODO</p>
 * <p>Copyright (c) 2018 yodes.cn Inc. All rights reserved.</p>
 * </pre>
 *
 * @author Yodes Yang
 * @since 2018/11/21
 */
@Component
public class ThreadPipeline implements Pipeline {
    private Logger log = LoggerFactory.getLogger(ThreadPipeline.class);
    private int count = 0;

    @Autowired
    private ThreadDao threadDao;

    @Override
    public void process(ResultItems resultItems, Task task) {
        ThreadEntity threadEntity = resultItems.get("threadEntity");
        List valid = anyIsNull(threadEntity);
        if (valid.size() > 0) {
            log.info("{} - NULL：{}", threadEntity.getSource(), valid);
        } else {
            threadDao.insert(threadEntity);
        }
        log.debug("{}", count++);
    }

    private List anyIsNull(ThreadEntity threadEntity) {
        List<String> lists = Lists.newArrayList();
        if (threadEntity.getTitle() == null) {
            lists.add("title");
        }
        if (threadEntity.getContent() == null) {
            lists.add("content");
        }
        if (threadEntity.getUpdateTime() == null) {
            lists.add("updateTime");
        }
        if (threadEntity.getType() == null) {
            lists.add("type");
        }

        return lists;
    }

}
