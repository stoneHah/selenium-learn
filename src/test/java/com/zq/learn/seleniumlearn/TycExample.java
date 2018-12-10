package com.zq.learn.seleniumlearn;

import com.zq.learn.seleniumlearn.downloader.WebDriverPool;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.Map;

public class TycExample {

    public static void main(String[] args) throws Exception {
        WebDriverPool pool = new WebDriverPool(1);

        WebDriver driver = pool.get();
        try {
//            driver.get("https://js.tianyancha.com/search?key=");

            WebDriver.Options manage = driver.manage();
            Map<String,String> cookieMap = getCookies();
            cookieMap.forEach((key,value) -> manage.addCookie(new Cookie.Builder(key,value).domain(".js.tianyancha.com").build()));

                driver.get("https://js.tianyancha.com/search?key=");

            WebElement webElement = driver.findElement(By.xpath("/html"));
            String content = webElement.getAttribute("outerHTML");

            System.out.println(content);
        }finally {
            pool.returnToPool(driver);
        }

    }

    public static Map<String,String> getCookies() {
        Map<String, String> cookies = new HashMap<>();
        cookies.put("Hm_lpvt_e92c8d65d92d534b0fc290df538b4758","1513056423");
        cookies.put("Hm_lvt_e92c8d65d92d534b0fc290df538b4758","1513049518,1513049582");
        cookies.put("OA","aY+HMigMROzc66QomhHhcDYyUFkJy3v719wy5nTk2Dzw2dhQFxKhxxAAbP3Qr4OTxnx742AkfZRBwopIfF4jGe8cwbgHZAHE621r1kUkFjRKQAtH83twsZ4dS3QdJXu5KLA41EG++tZH8B4C5vxrkw==");
        cookies.put("RTYCID","66e3b9b7504647308d34f5bd336f713a");
        cookies.put("TYCID","019cd400deed11e7a93f7113c22b709a");
        cookies.put("_csrf","7cablz1qbsoU+y1DW54+xQ==");
        cookies.put("_csrf_bk","9897968e6e2c7e3c1695a50b2ec13c31");

        cookies.put("_utm","186dc2428ede4b5f8897d4def7cd610e");
        cookies.put("aliyungf_tc","AQAAAPAfCmG9XAQAN/ay3eX6fDaHKhMs");
        cookies.put("auth_token","eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxNTM1MTUwNjczNiIsImlhdCI6MTUxMzA1NjU1MSwiZXhwIjoxNTI4NjA4NTUxfQ.MWNry9yzih-vilJfvOY60OIsEcfUEZBsLYoGHrXM5zdKP1GYMn3uRfRqBYFMPZ_jRyjNtmr_MfKaS3U6wlK7KA");
        cookies.put("csrfToken","GvhOPIYMafv3o1gJVaJ3q8oA");
        cookies.put("jsid","SEM-BAIDU-PZPC-000000");
        cookies.put("ssuid","5394738642");
        cookies.put("token","2c84f489d2f54d778aa882d4411ed5a7");
        cookies.put("tyc-user-info","%257B%2522token%2522%253A%2522eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxNTM1MTUwNjczNiIsImlhdCI6MTUxMzA1NjU1MSwiZXhwIjoxNTI4NjA4NTUxfQ.MWNry9yzih-vilJfvOY60OIsEcfUEZBsLYoGHrXM5zdKP1GYMn3uRfRqBYFMPZ_jRyjNtmr_MfKaS3U6wlK7KA%2522%252C%2522integrity%2522%253A%25220%2525%2522%252C%2522state%2522%253A%25220%2522%252C%2522vipManager%2522%253A%25220%2522%252C%2522vnum%2522%253A%25220%2522%252C%2522onum%2522%253A%25220%2522%252C%2522mobile%2522%253A%252215351506736%2522%257D");
        cookies.put("undefined","019cd400deed11e7a93f7113c22b709a");
        return cookies;
    }
}
