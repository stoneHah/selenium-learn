package com.zq.learn.seleniumlearn;

import com.zq.learn.seleniumlearn.action.SeleniumJSAction;
import com.zq.learn.seleniumlearn.downloader.SeleniumDownloader;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Task;

public class SeleniumDynamicJsExample {
    public static void main(String[] args) throws Exception {
        SeleniumDownloader downloader = new SeleniumDownloader();

        Request request = new Request("https://www.zhihu.com/question/40801731/answer/91814769");
        request.putExtra("action",new SeleniumJSAction("document.querySelector('.QuestionMainAction').click();" +
                "var more = document.querySelector('.QuestionRichText-more'); if(more){more.click()}"));

        downloader.download(request, new Task() {
            @Override
            public String getUUID() {
                return "123";
            }

            @Override
            public Site getSite() {
                return Site.me();
            }
        });

        /*WebDriverPool pool = new WebDriverPool(1);

        // Create a new instance of the Firefox driver
        // Notice that the remainder of the code relies on the interface,
        // not the implementation.
        WebDriver driver = pool.get();

        driver.get("https://www.zhihu.com/question/40801731/answer/91814769");
        Thread.sleep(1000);

        WebElement e = (WebElement)((JavascriptExecutor)driver).executeScript("document.querySelector('.QuestionMainAction').click();" +
                "var more = document.querySelector('.QuestionRichText-more'); if(more){more.click()}");

        WindowUtil.loadAll(driver);
//        long height=(Long)((JavascriptExecutor)driver).executeScript("return document.body.scrollHeight;");
//        System.out.println("height:" + height);
//        e.click();

//        phantom.executeScript("document.getElementsByClassName('QuestionRichText-more').click();");
//        phantom.executePhantomJS("document.getElementsByClassName('QuestionRichText-more').click();");

//        ((JavascriptExecutor)driver).executeScript("document.getElementsByClassName('QuestionRichText-more').click();");
//       WebElement webElement = (WebElement) ((JavascriptExecutor) driver).executeAsyncScript(
//                "document.getElementsByClassName('QuestionRichText-more').click();",
//                "document.getElementsByClassName('QuestionRichText-more').click();");
//        driver.findElement(By.className("QuestionRichText-more")).click();
//        webElement.click();

        WebElement questions = driver.findElement(By.className("RichText"));
        System.out.println(questions.getText());

        //Close the browser
//        driver.quit();
        pool.closeAll();*/
    }
}
