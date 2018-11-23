package cn.yodes.open.crawler.processor.game;

import org.apache.commons.lang3.StringUtils;
import org.assertj.core.util.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.List;

/**
 * <pre>
 * <p>Description: 站点收集器
 * <p>Copyright (c) 2018 yodes.cn Inc. All rights reserved.</p>
 * </pre>
 *
 * @author Yodes Yang
 * @since 2018/11/19
 */
public class SiteProcessor implements PageProcessor {
    private Logger log = LoggerFactory.getLogger(SiteProcessor.class);

    private Site site = Site.me()
            .setDomain("open.yodes.cn/Crawler")
            .setRetrySleepTime(3)
            .setSleepTime(200);

    @Override
    public void process(Page page) {
        List<String> url = page.getHtml().xpath("//*/div[@class='list-ctt-div']/li/a/@href").all();
        url.addAll(page.getHtml().xpath("//*/div[@class='list-div arc-list-wrap']/ul/li/a/@href").all());
        page.putField("url", url);
        String extendUrl = page.getHtml().xpath("//*/div[@class='la-pages']/ul/li[3]/a/@href").get();
        if (StringUtils.isNotBlank(extendUrl)) {
            page.addTargetRequests(extractUrls(page.getUrl().toString(), extendUrl));
        }
    }

    @Override
    public Site getSite() {
        return site;
    }

    private List<String> extractUrls(String baseUrl, String extendUrl) {
        List<String> urls = Lists.newArrayList();
        int minPage = 2, maxPage = 20;
        for (int i = minPage; i <= maxPage; i++){
            urls.add(baseUrl + extendUrl.replace("_2.html", "_" + i + ".html"));
        }
        return urls;
    }
}
