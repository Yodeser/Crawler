package cn.yodes.open.crawler.poems.service;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import us.codecraft.webmagic.Request;
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
        request.setCharset("utf-8");
        request.setMethod(HttpConstant.Method.POST);
        request.addHeader("Content-Type", "application/x-www-form-urlencoded");
        request.addHeader("X-Requested-With", "xmlhttprequest");

        List<NameValuePair> nvs = new ArrayList<>();
        nvs.add(new BasicNameValuePair("kw", authorName));
        nvs.add(new BasicNameValuePair("position", "0"));
        NameValuePair[] values = nvs.toArray(new NameValuePair[]{});
        Map<String, Object> params = new HashMap<>();
        params.put("nameValuePair", values);
        request.setExtras(params);
        return request;
    }
}
