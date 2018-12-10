package com.zq.learn.seleniumlearn.processor;

import com.zq.learn.seleniumlearn.downloader.SeleniumDownloader;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.List;

public class AngularJSPageProcessor implements PageProcessor {

    private static final String URL_DETAIL = "http://angularjs.cn/(\\w+)";

    private Site site = Site
            .me()
            .setDomain("blog.sina.com.cn")
            .setSleepTime(3000)
            .setUserAgent(
                    "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_7_2) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.65 Safari/537.31");

    @Override
    public void process(Page page) {
        String url = page.getRequest().getUrl();
        if(url.matches(URL_DETAIL)){//*[@id="A2MQ"]/div[1]/h3
            String id = page.getUrl().regex(URL_DETAIL).toString();
            System.out.println("article id:" + id);

            String title = page.getHtml().xpath("//*[@id=\""+id+"\"]/div[1]/h3/text()").toString();
            String content = page.getHtml().xpath("//*[@id=\""+id+"\"]/div[2]/tidyText()").toString();

            page.putField("title",title);
            page.putField("content",content);

        }else{
            List<String> all = page.getHtml().xpath("//*[@id=\"main\"]//ul[@class=\"media-list ng-scope\"]//div[@class=\"media-header\"]").links().regex(URL_DETAIL).all();
            page.addTargetRequests(all);
        }
    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        SeleniumDownloader downloader = new SeleniumDownloader();
        downloader.setSleepTime(2000);
        Spider.create(new AngularJSPageProcessor()).setDownloader(downloader).addUrl("http://angularjs.cn/")
                .run();
    }
}
