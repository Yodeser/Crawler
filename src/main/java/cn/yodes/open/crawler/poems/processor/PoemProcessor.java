package cn.yodes.open.crawler.poems.processor;

import cn.yodes.open.crawler.poems.domain.PoemEntity;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.List;

public class PoemProcessor implements PageProcessor {
    private Site site = Site.me()
            .setDomain("http://www.shicimingju.com/")
            .setRetrySleepTime(3)
            .setSleepTime(1000);

    @Override
    public void process(Page page) {
        List<String> links = page.getHtml().xpath("//*[@class='www-shadow-card www-main-container']").links().regex("http://www.shicimingju.com/chaxun/list/\\d+.html").all();
        page.addTargetRequests(links);
        if (page.getUrl().regex("http://www.shicimingju.com/chaxun/list/\\d+.html").match()) {

            PoemEntity poem = new PoemEntity();
            poem.setTitle(page.getHtml().xpath("//*/h1[@class='shici-title']/text()").toString().trim());
            poem.setDynasty(page.getHtml().xpath("//*/div[@class='shici-info']/text()").toString().trim());
            poem.setAuthor(page.getHtml().xpath("//*/div[@class='shici-info']/a/text()").toString().trim());
            poem.setContent(page.getHtml().xpath("//*/div[@class='shici-content']/text()").toString().trim());
            poem.setTags(page.getHtml().xpath("//*/div[@class='shici-mark']/a/text()").all());
            if(page.getHtml().xpath("//*/div[@class='shangxi-container']/text()").match()) {
                poem.setAppreciation(page.getHtml().xpath("//*/div[@class='shangxi-container']/text()").toString().trim());
            }else{
                poem.setAppreciation("本文无赏析");
            }

            page.putField("poem", poem);
        }
    }

    @Override
    public Site getSite() {
        return site;
    }


}