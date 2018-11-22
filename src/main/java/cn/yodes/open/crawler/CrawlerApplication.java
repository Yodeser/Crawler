package cn.yodes.open.crawler;

import cn.yodes.open.crawler.web.ThreadCrawler;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@SpringBootApplication
@MapperScan("cn.yodes.open.crawler.dal")
@RestController
public class CrawlerApplication {
    @Autowired
    private ThreadCrawler threadCrawler;

    public static void main(String[] args)  {
        SpringApplication.run(CrawlerApplication.class, args);
    }

    @RequestMapping(value = "/spider", method = RequestMethod.GET)
    public String spider() throws IOException {
        threadCrawler.start();
        return "ok";
    }
}
