package cn.yodes.open.crawler.poems.processor;

import cn.yodes.open.crawler.poems.domain.AuthorEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.JsonPathSelector;

/**
 * <pre>
 * <p>Description: //TODO</p>
 * <p>Copyright (c) 2018 open.yodes.cn Inc. All rights reserved.</p>
 * </pre>
 *
 * @author Yodes Yang
 * @since 2018/3/29 14:58
 */
public class AuthorProcessor implements PageProcessor {
    private Logger log = LoggerFactory.getLogger(AuthorProcessor.class);
    private Site site = Site.me()
            .setDomain("open.yodes.cn/Crawler")
            .setRetrySleepTime(3)
            .setSleepTime(1000);

    @Override
    public void process(Page page) {
        log.info(page.getRawText());
        int total = Integer.parseInt(new JsonPathSelector("$.zuozhes.total").select(page.getRawText()));
        page.putField("total", total);
        if (total >= 1) {
            AuthorEntity author = new AuthorEntity();
            author.setId(Integer.parseInt(new JsonPathSelector("$.zuozhes.zuozhes[0].id").select(page.getRawText())));
            author.setAuthorName(new JsonPathSelector("$.zuozhes.zuozhes[0].zuozhe").select(page.getRawText()));
            author.setDynasty(new JsonPathSelector("$.zuozhes.zuozhes[0].niandai").select(page.getRawText()));
            author.setPoemNum(new JsonPathSelector("$.zuozhes.zuozhes[0].num").select(page.getRawText()));
            author.setSummary(new JsonPathSelector("$.zuozhes.zuozhes[0].summary").select(page.getRawText()));
            author.setPicRoute(new JsonPathSelector("$.zuozhes.zuozhes[0].pic").select(page.getRawText()));
            page.putField("author", author);
        }
    }

    @Override
    public Site getSite() {
        return site;
    }

}
