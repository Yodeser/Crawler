package cn.yodes.open.crawler.processor.game;

import cn.yodes.open.crawler.domain.ThreadEntity;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;

import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <pre>
 * <p>Description: //TODO</p>
 * <p>Copyright (c) 2018 yodes.cn Inc. All rights reserved.</p>
 * </pre>
 *
 * @author Yodes Yang
 * @since 2018/11/21
 */
public class ThreadProcessor implements PageProcessor {

    private Site site = Site.me()
            .setDomain("open.yodes.cn/Crawler")
            .setRetrySleepTime(3)
            .setSleepTime(200);

    @Override
    public void process(Page page) {
        ThreadEntity threadEntity = new ThreadEntity();
        Html html = page.getHtml();
        threadEntity.setTitle(html.xpath("//*/div[@class='mainbox clearfix']/div/h1").get());
        threadEntity.setContent(html.xpath("//*/div[@class='arc-body']/div[1] | //*/div[@class='arc-body']").get());
        threadEntity.setType(html.xpath("//*/div[@class='position']/a[3]").get());
        threadEntity.setUpdateTime(Calendar.getInstance().getTime().toString());
        threadEntity.setSource(page.getUrl().toString());

        page.putField("threadEntity", threadEntity);
    }

    @Override
    public Site getSite() {
        return site;
    }

    public synchronized String delHTMLTag(String htmlStr) {
        //定义正则表达式
        String regEx_script = "<script[^>]*?>[\\s\\S]*?<\\/script>";
        String regEx_style = "<style[^>]*?>[\\s\\S]*?<\\/style>";
        String regEx_html = "<[^>]+>";

        Pattern p_script = Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE);
        Matcher m_script = p_script.matcher(htmlStr);
        htmlStr = m_script.replaceAll("");

        Pattern p_style = Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE);
        Matcher m_style = p_style.matcher(htmlStr);
        htmlStr = m_style.replaceAll("");

        Pattern p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
        Matcher m_html = p_html.matcher(htmlStr);
        htmlStr = m_html.replaceAll("");

        return htmlStr.trim();
    }
}
