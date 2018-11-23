package cn.yodes.open.crawler.utils;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    public static String filterHtmlTag(String htmlStr) {
        //定义正则表达式
        String regExScript = "<script[^>]*?>[\\s\\S]*?</script>";
        String regExStyle = "<style[^>]*?>[\\s\\S]*?</style>";
        String regExHtml = "<[^>]+>";

        Pattern pScript = Pattern.compile(regExScript, Pattern.CASE_INSENSITIVE);
        Matcher mScript = pScript.matcher(htmlStr);
        htmlStr = mScript.replaceAll("");

        Pattern pStyle = Pattern.compile(regExStyle, Pattern.CASE_INSENSITIVE);
        Matcher mStyle = pStyle.matcher(htmlStr);
        htmlStr = mStyle.replaceAll("");

        Pattern pHtml = Pattern.compile(regExHtml, Pattern.CASE_INSENSITIVE);
        Matcher mHtml = pHtml.matcher(htmlStr);
        htmlStr = mHtml.replaceAll("");

        return htmlStr.trim();
    }
}
