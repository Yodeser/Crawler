package cn.yodes.open.crawler.pipeline.music;

import org.apache.commons.lang3.StringUtils;
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
 * @since 2018/4/10
 */
public class MusicPipeline implements Pipeline {
    public Logger log = LoggerFactory.getLogger(MusicPipeline.class);

    private StringBuilder ircBuilder = new StringBuilder();

    @Override
    public void process(ResultItems resultItems, Task task) {
        if (StringUtils.isNotBlank(resultItems.get("IRC"))) {
            ircBuilder.append(resultItems.get("IRC").toString()).append("\n");
        }
    }

    public String getIrcStr() {
        return ircBuilder.toString();
    }
}
