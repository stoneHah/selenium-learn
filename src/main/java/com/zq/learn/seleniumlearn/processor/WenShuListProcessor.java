package com.zq.learn.seleniumlearn.processor;

import com.zq.learn.seleniumlearn.downloader.ComposeDownloader;
import com.zq.learn.seleniumlearn.downloader.SeleniumDownloader;
import com.zq.learn.seleniumlearn.downloader.rule.RequestRegexMathRule;
import com.zq.learn.seleniumlearn.spider.MySpider;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.model.HttpRequestBody;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Json;
import us.codecraft.webmagic.utils.HttpConstant;

import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * ${DESCRIPTION}
 *
 * @author qun.zheng
 * @create 2018/12/10
 **/
public class WenShuListProcessor implements PageProcessor, Closeable {

    private Logger logger = LoggerFactory.getLogger(WenShuListProcessor.class);

    public static final String URL_LIST = "http://wenshu\\.court\\.gov\\.cn/List/ListContent";
    public static final String URL_WENSHU = "http://wenshu\\.court\\.gov\\.cn/content/content?.*";

    private Site site = Site.me().setRetryTimes(3)
            .setCycleRetryTimes(3)
            .setTimeOut(10000).setSleepTime(1000);
    private WebDriver webDriver = null;

    public WenShuListProcessor() {
        initWebShuListWebDriver();
    }

    private void initWebShuListWebDriver() {
        System.setProperty("webdriver.chrome.driver", "F:\\spider\\driver\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.get("http://wenshu.court.gov.cn/List/List?sorttype=1&conditions=searchWord+1+AJLX++%E6%A1%88%E4%BB%B6%E7%B1%BB%E5%9E%8B:%E5%88%91%E4%BA%8B%E6%A1%88%E4%BB%B6");
       /* (new WebDriverWait(webDriver, 60)).until(ExpectedConditions.javaScriptThrowsNoExceptions(
                "var id='DcONSQHDgEAIw4BASyw3T07Dv8KSWgHDicKswqLCsHnCmlDDoQzClsKUwq7CpFLCrDLCjEvCljDCgSlEPCbCuhN6wq5OwqTDiMOWw4I7w53Chn3DiALChTLDnsKTScO5R8KlwoFvLQouBcKxw4fCt0nDpm3DqhzCjRXDnz7DoxYbw7BuLMKAw58Pw4BLwoLCqkbDhMK0wolpw7HDq3Ztw5wYw4zDn8OBw7LClMKtw7nCn8K0UcKjUsKZGnMOwpPDvsKeQSUvFCt/';" +
                        "var unzipid=unzip(id);" +
                        "return com.str.Decrypt(unzipid)"));
        ExpectedConditions.presenceOfNestedElementsLocatedBy(By.id("resultList"),By.className("dataItem"))*/
        (new WebDriverWait(webDriver, 60)).until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver webDriver) {
                List<WebElement> allChildren = webDriver.findElements(By.cssSelector("#resultList .dataItem"));
                if (CollectionUtils.isEmpty(allChildren)) {
                    return false;
                }
                try {
                    ((JavascriptExecutor) webDriver).executeScript(
                        "var id='DcONSQHDgEAIw4BASyw3T07Dv8KSWgHDicKswqLCsHnCmlDDoQzClsKUwq7CpFLCrDLCjEvCljDCgSlEPCbCuhN6wq5OwqTDiMOWw4I7w53Chn3DiALChTLDnsKTScO5R8KlwoFvLQouBcKxw4fCt0nDpm3DqhzCjRXDnz7DoxYbw7BuLMKAw58Pw4BLwoLCqkbDhMK0wolpw7HDq3Ztw5wYw4zDn8OBw7LClMKtw7nCn8K0UcKjUsKZGnMOwpPDvsKeQSUvFCt/';" +
                                "var unzipid=unzip(id);" +
                                "return com.str.Decrypt(unzipid)"
                    );
                    return true;
                } catch (WebDriverException e) {
                    return false;
                }
            }
        });
    }

    @Override
    public void process(Page page) {
        if (page.getUrl().regex(URL_LIST).match()) {
            processList(page);
        }else if (page.getUrl().regex(URL_WENSHU).match()) {
            processWenShu(page);
        }

    }

    private void processWenShu(Page page) {
        System.out.println("");
        String contentTitle = page.getHtml().xpath("//*[@id='contentTitle']/text()").get();
        page.putField("contentTitle",contentTitle);
    }

    private void processList(Page page) {
        String rawText = page.getRawText();
        if (StringUtils.hasText(rawText)) {
            rawText = rawText.substring(1, rawText.length() - 1)
                    .replaceAll("\\\\\"", "\"");
            page.setRawText(rawText);

            Json json = page.getJson();
            List<Map> list = json.toList(Map.class);
            if (!CollectionUtils.isEmpty(list)) {
                for (Map map : list) {
                    if (map.containsKey("文书ID")) {
                        String encryDocId = (String) map.get("文书ID");
                        /*var unzipid=unzip(id);try{var realid=com.str.Decrypt(unzipid)*/
                        System.out.println("=========================加密文档id:" + encryDocId);
                        page.putField("docId", map.get("文书ID"));
                        String docId = null;
                        try {
                            docId = (String) ((JavascriptExecutor) webDriver).executeScript("var unzipid=unzip(arguments[0]);" +
                                    "return com.str.Decrypt(unzipid)", encryDocId);
                            if (StringUtils.hasText(docId)) {
                                //获取到文档id
                                page.addTargetRequest(String.format("http://wenshu.court.gov.cn/content/content?DocID=%s&KeyWord=",docId));
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            logger.error("解密文书id={}失败",docId);
                        }
                    }
                }
            }
        }
    }

    @Override
    public Site getSite() {
        return site;
    }

    @Override
    public void close() throws IOException {
        if (webDriver != null) {
//            webDriver.quit();
        }
    }


    public static void main(String[] args) {
        SeleniumDownloader seleniumDownloader = new SeleniumDownloader("F:\\spider\\driver\\chromedriver.exe");
        seleniumDownloader.addExpectedCondition(new RequestRegexMathRule(URL_WENSHU),new ExpectedCondition<Boolean>(){

            @Override
            public Boolean apply(WebDriver webDriver) {
                String contentTitle = webDriver.findElement(By.id("contentTitle")).getText();
                return StringUtils.hasText(contentTitle);
            }
        });

        ComposeDownloader downloader = new ComposeDownloader();
        downloader.addDownloader(new RequestRegexMathRule(URL_WENSHU),seleniumDownloader);

        Request request = new Request("http://wenshu.court.gov.cn/List/ListContent");
        request.setMethod(HttpConstant.Method.POST);
        request.setRequestBody(HttpRequestBody.form(formData(), "utf-8"));
        MySpider.create(new WenShuListProcessor()).addRequest(request)
                .setDownloader(downloader)
                .run();
    }

    private static Map<String, Object> formData() {
        Map<String, Object> map = new HashMap<>();
        map.put("Param", "案件类型:刑事案件");
        map.put("Index", 1);
        map.put("Page", 10);
        map.put("Order", "法院层级");
        map.put("Direction", "asc");
        map.put("vl5x", "2547a853192c83add99174a5");
        map.put("number", "wens");
        map.put("guid", "4716ab5f-08a9-b5ed080e-3db96209cec2");
        return map;
    }


}
