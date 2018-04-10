package cn.yodes.open.crawler.processor.music;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.List;

/**
 * <pre>
 * <p>Description: //TODO</p>
 * <p>Copyright (c) 2018 open.yodes.cn Inc. All rights reserved.</p>
 * </pre>
 *
 * @author Yodes Yang
 * @since 2018/4/10
 */
public class MusicProcessor implements PageProcessor {
    private Logger log = LoggerFactory.getLogger(MusicProcessor.class);

    private Site site = new Site().setRetrySleepTime(3).setSleepTime(1000)
            .setDomain("www.xiami.com")
            .addCookie("xmgid", "caf7ae42-71a5-4aaa-8138-caf1f449a40e")
            .addCookie("cna", "64sjE7ahWzgCAS10CU4vaVsQ")
            .addCookie("xm_token", "a75a750a0b92df2c749de6ee88e6711c")
            .addCookie("uidXM", "335525404")
            .addCookie("member_auth", "hjrKGtkeuWFjhPDCTI9jciFM4eSHGzTTxd9XjuV8swsjJ4YKZYPxx6uSQQ5N2iWXqFwmfeLIiHg")
            .addCookie("_xiamitoken", "bf78888b02f49619425878ec2e2188cb")
            .addCookie("_unsign_token", "bb23a9c3d04828bdf38430239cc7c885")
            .addCookie("UM_distinctid", "162ad8c99aa35-0f8e00236ca8d8-454c062c-144000-162ad8c99ab16f")
            .addCookie("user", "335525404%22Yodes%22images%2Favatar_new%2F1726871712_1510749202.jpg%220%22147%22%3Ca+href%3D%27http%3A%2F%2Fwww.xiami.com%2Fwebsitehelp%23help9_3%27+%3ELv3%3C%2Fa%3E%223%220%2270%22b519df5ca2%221523330094")
            .addCookie("t_sign_auth", "1")
            .setUserAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36");

    @Override
    public void process(Page page) {
        if (page.getUrl().regex("http://www.xiami.com/song/\\S+").match()) {
            String irc = page.getHtml().xpath("//*[@class='lrc_main']/text()").toString();
            String info = page.getHtml().xpath("//*/td[@valign='top']/div/a/text()").toString();
            if (StringUtils.isNotBlank(irc)) {
                page.putField("IRC", irc);
                page.putField("INFO", info);
            } else {
                log.warn("{}", page.getRequest().toString());
            }
        } else {
            List<String> links = page.getHtml().xpath("//*/div/div[@class='content']").links().regex("http://www.xiami.com/song/\\S+").all();
            page.addTargetRequests(links);
        }
    }

    @Override
    public Site getSite() {
        return site;
    }
}
