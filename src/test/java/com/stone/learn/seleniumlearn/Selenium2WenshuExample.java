package com.stone.learn.seleniumlearn;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * ${DESCRIPTION}
 *
 * @author qun.zheng
 * @create 2018/12/10
 **/
public class Selenium2WenshuExample {
    public static void main(String[] args) {
        // Create a new instance of the Firefox driver
        // Notice that the remainder of the code relies on the interface,
        // not the implementation.
//        System.setProperty("webdriver.chrome.driver", "/Users/bianweiping/Documents/spider/driver/chromedriver");
        System.setProperty("webdriver.chrome.driver", "F:\\spider\\driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // And now use this to visit Google
        driver.get("http://wenshu.court.gov.cn/List/List?sorttype=1&conditions=searchWord+2+AJLX++%E6%A1%88%E4%BB%B6%E7%B1%BB%E5%9E%8B:%E6%B0%91%E4%BA%8B%E6%A1%88%E4%BB%B6");
        (new WebDriverWait(driver, 60)).until(ExpectedConditions.javaScriptThrowsNoExceptions(
                "var id='DcOOwrkBA0EIBMKwwpbCuMOlG0LDnsO+S8KyM8KFwrJwFMKGwoQ6Hn/Cu8KTZ8ONw5Ifwr9Nw70Gw41PDxLDqX/CvcKXT8OBOcKwcTpmUcO/wrTCjG5hwrzCqz5PV8KYLysuUcK5Yh5WNAsnVMKPwpxdOj9Hw5LDkUdpUyHDlVV4TMOhwrLCunTCoMKmwq/CghdHw70/w6k8woprwpkYw6xVw5Nkwq0vJxwbbhzDiE3Dt8KBJsKswrXDjsK8wqLDrQc=';" +
                "var unzipid=unzip(id);" +
                "return com.str.Decrypt(unzipid)"));

        String encryDocId = "DcOOwrkBA0EIBMKwwpbCuMOlG0LDnsO+S8KyM8KFwrJwFMKGwoQ6Hn/Cu8KTZ8ONw5Ifwr9Nw70Gw41PDxLDqX/CvcKXT8OBOcKwcTpmUcO/wrTCjG5hwrzCqz5PV8KYLysuUcK5Yh5WNAsnVMKPwpxdOj9Hw5LDkUdpUyHDlVV4TMOhwrLCunTCoMKmwq/CghdHw70/w6k8woprwpkYw6xVw5Nkwq0vJxwbbhzDiE3Dt8KBJsKswrXDjsK8wqLDrQc=";
        for (int i = 0; i < 10; i++) {
            try {
                Object docId = ((JavascriptExecutor) driver).executeScript("var unzipid=unzip(arguments[0]);" +
                        "return com.str.Decrypt(unzipid)", encryDocId);
                System.out.println("=========================文档id:" + docId);
            }catch (Exception e){
                e.printStackTrace();
            }
        }



        //Close the browser
        driver.quit();
    }
}
