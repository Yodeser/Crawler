package cn.yodes.open.crawler.utils;

import org.apache.commons.io.FileUtils;

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
public class TextUtils {
    public static String filterSongInfo() {
        String[] detailInfo = new String[]{
                "作曲：", "作词 :", "作词：", "演唱：", "词/曲：", "原唱：", "翻唱：", "词：", "曲：", "歌名：", "歌手：", "专辑：",
                "编曲：", "词曲：", "母带处理：", "音乐发行：", "美工：", "后期制作：",
                "录音：", "混缩：", "吉他：", "和声：", "制作人：", "录音室：", "混音室："
        };
        return "";
    }

    public static String filterOthers() throws IOException {
        String textStr = FileUtils.readFileToString(new File("C:\\Users\\Administrator\\Desktop\\Spider\\Music\\Hip-Hop\\all_irc.txt"), "utf8");
        return textStr.replaceAll("[^a-zA-Z\\s+']", "").toLowerCase();

    }
}
