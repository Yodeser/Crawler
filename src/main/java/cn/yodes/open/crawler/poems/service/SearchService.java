package cn.yodes.open.crawler.poems.service;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.model.HttpRequestBody;
import us.codecraft.webmagic.pipeline.ResultItemsCollectorPipeline;
import us.codecraft.webmagic.utils.HttpConstant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <pre>
 * <p>Description: //TODO</p>
 * <p>Copyright (c) 2018 open.yodes.cn Inc. All rights reserved.</p>
 * </pre>
 *
 * @author Yodes Yang
 * @since 2018/3/29 14:58
 */
public class SearchService {
    public Request searchAuthor(String authorName) {
        Request request = new Request("http://www.shicimingju.com/webApi/ajaxSearch");
//        request.setCharset("utf-8");
        request.setMethod(HttpConstant.Method.POST);
        request.addHeader("Content-Type", HttpRequestBody.ContentType.FORM);
        request.addHeader("X-Requested-With", "xmlhttprequest");

        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("kw", authorName);
        dataMap.put("position", "0");
        request.setRequestBody(HttpRequestBody.form(dataMap, "utf-8"));
        return request;
    }
}
