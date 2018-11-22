package cn.yodes.open.crawler.pipeline.game;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

/**
 * <pre>
 * <p>Description: //TODO</p>
 * <p>Copyright (c) 2018 yodes.cn Inc. All rights reserved.</p>
 * </pre>
 *
 * @author Yodes Yang
 * @since 2018/11/19
 */
public class SitePipeline implements Pipeline {
    Logger log = LoggerFactory.getLogger(SitePipeline.class);
    private int count = 0;

    @Override
    public void process(ResultItems resultItems, Task task) {
        List<String> results = resultItems.get("url");
//        results.forEach(System.out::println);
        count += results.size();

        File file = new File(System.getProperty("user.dir") + "/data/siteUrls.txt");
        FileOutputStream fileOutputStream = null;
        OutputStreamWriter osw = null;
        try {
            if (!file.exists()) {
                file.createNewFile();
                fileOutputStream = new FileOutputStream(file);
            } else {
                //如果文件已存在，那么就在文件末尾追加写入
                fileOutputStream = new FileOutputStream(file, true);
            }
            osw = new OutputStreamWriter(fileOutputStream, "UTF-8");
            for (String result : results) {
                osw.write(result + "\n");
            }
        }catch (Exception e){
            System.out.println(e.toString());
        }finally {
            try {
                osw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
