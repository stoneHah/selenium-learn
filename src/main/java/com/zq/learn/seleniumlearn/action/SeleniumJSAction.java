package com.zq.learn.seleniumlearn.action;

import com.zq.learn.seleniumlearn.expression.resolver.ExpressionResolver;
import com.zq.learn.seleniumlearn.util.WindowUtil;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class SeleniumJSAction implements SeleniumAction{

    private String jsExpression;

    private ExpressionResolver expressionResolver = new ExpressionResolver();

    public SeleniumJSAction(String jsExpression) {
        this.jsExpression = jsExpression;
    }

    @Override
    public void execute(WebDriver webDriver) {
        ((JavascriptExecutor)webDriver).executeScript(expressionResolver.resolve(jsExpression).getExpression());

        WindowUtil.loadAll(webDriver);
    }
}
