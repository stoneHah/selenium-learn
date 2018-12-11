package com.zq.learn.seleniumlearn.downloader;

import com.zq.learn.seleniumlearn.action.SeleniumAction;
import com.zq.learn.seleniumlearn.downloader.rule.RequestMathRule;
import com.zq.learn.seleniumlearn.util.WindowUtil;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.downloader.Downloader;
import us.codecraft.webmagic.selector.Html;
import us.codecraft.webmagic.selector.PlainText;

import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 使用Selenium调用浏览器进行渲染。目前仅支持chrome。<br>
 * 需要下载Selenium driver支持。<br>
 *
 * @author code4crafter@gmail.com <br>
 *         Date: 13-7-26 <br>
 *         Time: 下午1:37 <br>
 */
public class SeleniumDownloader implements Downloader, Closeable {

	private volatile WebDriverPool webDriverPool;

	private Logger logger = Logger.getLogger(getClass());

	private int sleepTime = 0;

	private int poolSize = 1;

	/**
	 * 默认资源等待时间
	 */
	private int defaultReourceWaitTime = 60;
	private Map<RequestMathRule, ExpectedCondition> resourceExpectedConditionMap = new HashMap<>();

	/**
	 * 新建
	 *
	 * @param chromeDriverPath chromeDriverPath
	 */
	public SeleniumDownloader(String chromeDriverPath) {
		System.getProperties().setProperty("webdriver.chrome.driver",
				chromeDriverPath);
	}

	/**
	 * Constructor without any filed. Construct PhantomJS browser
	 * 
	 * @author bob.li.0718@gmail.com
	 */
	public SeleniumDownloader() {
		// System.setProperty("phantomjs.binary.path",
		// "/Users/Bingo/Downloads/phantomjs-1.9.7-macosx/bin/phantomjs");
	}

	/**
	 * set sleep time to wait until load success
	 *
	 * @param sleepTime sleepTime
	 * @return this
	 */
	public SeleniumDownloader setSleepTime(int sleepTime) {
		this.sleepTime = sleepTime;
		return this;
	}

	public void setDefaultReourceWaitTime(int defaultReourceWaitTime) {
		this.defaultReourceWaitTime = defaultReourceWaitTime;
	}

	public void addExpectedCondition(RequestMathRule rule,ExpectedCondition cond){
		resourceExpectedConditionMap.put(rule, cond);
	}

	@Override
	public Page download(Request request, Task task) {
		checkInit();
		WebDriver webDriver;
		try {
			webDriver = webDriverPool.get();
		} catch (InterruptedException e) {
			logger.warn("interrupted", e);
			return null;
		}
		logger.info("downloading page " + request.getUrl());
		webDriver.get(request.getUrl());

		//一直等待，直到资源加载完毕
		waitUnitResourceLoaded(webDriver,request);

		WebDriver.Options manage = webDriver.manage();
		Site site = task.getSite();
		if (site.getCookies() != null) {
			for (Map.Entry<String, String> cookieEntry : site.getCookies()
					.entrySet()) {
				Cookie cookie = new Cookie(cookieEntry.getKey(),
						cookieEntry.getValue());
				manage.addCookie(cookie);
			}
		}

		SeleniumAction reqAction=(SeleniumAction) request.getExtra("action");
		if(reqAction!=null){
			reqAction.execute(webDriver);
		}

		/*((JavascriptExecutor)webDriver).executeScript("document.querySelector('.QuestionMainAction').click();" +
				"var more = document.querySelector('.QuestionRichText-more'); if(more){more.click()}");*/

		WindowUtil.loadAll(webDriver);

//		webDriver.manage().window().maximize();

		/*
		 * TODO You can add mouse event or other processes
		 * 
		 * @author: bob.li.0718@gmail.com
		 */

		WebElement webElement = webDriver.findElement(By.xpath("/html"));
		String content = webElement.getAttribute("outerHTML");
		Page page = new Page();
		page.setRawText(content);
		page.setHtml(new Html(content, request.getUrl()));
		page.setUrl(new PlainText(request.getUrl()));
		page.setRequest(request);
		webDriverPool.returnToPool(webDriver);
		return page;
	}

	/**
	 * 等待资源，直到加载完毕
	 * @param webDriver
	 * @param request
	 */
	private void waitUnitResourceLoaded(WebDriver webDriver, Request request) {
		boolean matchRule = false;
		Iterator<Entry<RequestMathRule, ExpectedCondition>> iterator = resourceExpectedConditionMap.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<RequestMathRule, ExpectedCondition> entry = iterator.next();
			if(entry.getKey().match(request)){
				matchRule = true;
				try {
					(new WebDriverWait(webDriver, defaultReourceWaitTime)).until(entry.getValue());
				} catch (TimeoutException e) {
					e.printStackTrace();
				}
				break;
			}
		}

		if(!matchRule){
			try {
				Thread.sleep(sleepTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void checkInit() {
		if (webDriverPool == null) {
			synchronized (this) {
				webDriverPool = new WebDriverPool(poolSize);
			}
		}
	}

	@Override
	public void setThread(int thread) {
		this.poolSize = thread;
	}

	@Override
	public void close() throws IOException {
		webDriverPool.closeAll();
	}
}
