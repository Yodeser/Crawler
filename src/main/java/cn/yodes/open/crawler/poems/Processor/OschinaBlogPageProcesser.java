package cn.yodes.open.crawler.poems.Processor;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.List;

public class OschinaBlogPageProcesser implements PageProcessor {

    private Site site = Site.me()
            .setDomain("open.yodes.cn/Crawler")
            .setRetrySleepTime(3)
            .setSleepTime(1000);

    @Override
    public void process(Page page) {
        List<String> links = page.getHtml().links().regex("http://www.shicimingju.com/chaxun/list/46932.html").all();
        page.addTargetRequests(links);
        page.putField("title", page.getHtml().xpath("//*/h1[@class='shici-title']/text()"));
        page.putField("dynasty", page.getHtml().xpath("//*/div[@class='shici-info']/text()"));
        page.putField("author", page.getHtml().xpath("//*/div[@class='shici-info']/a/text()"));
        page.putField("content", page.getHtml().xpath("//*/div[@class='shici-content']/text()"));
        page.putField("tags", page.getHtml().xpath("//*/div[@class='shici-mark']/a/text()").all());
        page.putField("others", page.getHtml().xpath("//*/div[@class='shangxi-container']/text()"));
    }

    @Override
    public Site getSite() {
        return site;

    }

    public static void main(String[] args) {
        Spider.create(new OschinaBlogPageProcesser()).addUrl("http://www.shicimingju.com/chaxun/zuozhe/29.html")
                .addPipeline(new ConsolePipeline()).run();
    }
}