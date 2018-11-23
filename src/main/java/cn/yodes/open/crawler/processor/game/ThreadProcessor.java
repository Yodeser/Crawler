package cn.yodes.open.crawler.processor.game;

import cn.yodes.open.crawler.domain.ThreadEntity;
import cn.yodes.open.crawler.utils.TextUtils;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * <pre>
 * <p>Description: 帖子收集器
 * <p>Copyright (c) 2018 yodes.cn Inc. All rights reserved.</p>
 * </pre>
 *
 * @author Yodes Yang
 * @since 2018/11/21
 */
public class ThreadProcessor implements PageProcessor {

    private Site site = Site.me()
            .setDomain("open.yodes.cn/Crawler")
            .setCharset("UTF-8")
            .setRetrySleepTime(3)
            .setSleepTime(200);
    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public void process(Page page) {
        ThreadEntity threadEntity = new ThreadEntity();
        Html html = page.getHtml();
        threadEntity.setTitle(TextUtils.filterHtmlTag(html.xpath("//*/div[@class='mainbox clearfix']/div/h1").get()));
        threadEntity.setContent(TextUtils.filterHtmlTag(html.xpath("//*/div[@class='arc-body']/div[1] | //*/div[@class='arc-body']").get()));
        threadEntity.setType(TextUtils.filterHtmlTag(html.xpath("//*/div[@class='position']/a[3]").get()));
        threadEntity.setUpdateTime(format.format(Calendar.getInstance().getTime()));
        threadEntity.setSource(page.getUrl().toString());

        page.putField("threadEntity", threadEntity);
    }

    @Override
    public Site getSite() {
        return site;
    }
}
