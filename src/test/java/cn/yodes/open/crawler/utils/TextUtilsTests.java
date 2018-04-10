package cn.yodes.open.crawler.utils;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
public class TextUtilsTests {
    private Logger log = LoggerFactory.getLogger(TextUtilsTests.class);

    @Test
    public void filterOthers() throws IOException {
        String outputUri = "C:\\Users\\Administrator\\Desktop\\Spider\\Music\\Hip-Hop\\Format\\formatIrc.txt";
        String formatStr = TextUtils.filterOthers();
        FileUtils.writeStringToFile(new File(outputUri), formatStr, "utf8");
    }
}
