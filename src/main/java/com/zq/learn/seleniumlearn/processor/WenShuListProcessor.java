package com.zq.learn.seleniumlearn.processor;

import org.springframework.core.annotation.Order;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.model.HttpRequestBody;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Json;
import us.codecraft.webmagic.utils.HttpConstant;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * ${DESCRIPTION}
 *
 * @author qun.zheng
 * @create 2018/12/10
 **/
public class WenShuListProcessor implements PageProcessor{
    private Site site = Site.me().setRetryTimes(3)
            .setCycleRetryTimes(3)
            .setTimeOut(10000).setSleepTime(1000);

    @Override
    public void process(Page page) {
        String rawText = page.getRawText();
        if (StringUtils.hasText(rawText)) {
            rawText = rawText.substring(1, rawText.length() - 1)
                        .replaceAll("\\\\\"","\"");
            page.setRawText(rawText);

            Json json = page.getJson();
            List<Map> list = json.toList(Map.class);
            if (!CollectionUtils.isEmpty(list)) {
                for (Map map : list) {
                    if(map.containsKey("文书ID")){
                        page.putField("文书ID",map.get("文书ID"));
                    }
                }
            }
        }
    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        Request request = new Request("http://wenshu.court.gov.cn/List/ListContent");
        request.setMethod(HttpConstant.Method.POST);
        request.setRequestBody(HttpRequestBody.form(formData(),"utf-8"));
        Spider.create(new WenShuListProcessor()).addRequest(request)
                .run();
    }

    /*Param: 案件类型:民事案件
    Index: 1
    Page: 10
    Order: 法院层级
    Direction: asc
    vl5x: 9525fb31635be0b4742d071b
    number: wens
    guid: 538f340d-7ed1-03f5be97-25221b2b4a2b*/
    private static Map<String, Object> formData() {
        Map<String, Object> map = new HashMap<>();
        map.put("Param","案件类型:刑事案件");
        map.put("Index",1);
        map.put("Page",10);
        map.put("Order","法院层级");
        map.put("Direction","asc");
        map.put("vl5x","55d8f7d27fb72afcdd6e68a4");
        map.put("number","wens");
        map.put("guid","9ab9e3ef-b477-9058ab76-e90992641922");
        return map;
    }
}
