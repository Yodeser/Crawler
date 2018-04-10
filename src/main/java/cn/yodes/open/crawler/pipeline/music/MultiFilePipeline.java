package cn.yodes.open.crawler.pipeline.music;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.assertj.core.internal.bytebuddy.utility.RandomString;
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
 * @since 2018/4/10
 */
public class MultiFilePipeline implements Pipeline {

    @Override
    public void process(ResultItems resultItems, Task task) {
        String irc = resultItems.get("IRC").toString();
        String info = resultItems.get("INFO").toString();
        String outputBaseUri = "C:\\Users\\Administrator\\Desktop\\Spider\\Music\\Hip-Hop\\Corpus\\";
        File file = new File(outputBaseUri + (StringUtils.isNotBlank(info) ? info : RandomString.make()) + ".txt");

        if (StringUtils.isNotBlank(irc)) {
            try {
                FileUtils.writeStringToFile(file, irc, "utf8");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
