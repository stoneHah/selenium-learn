package com.zq.learn.seleniumlearn.downloader.rule;

import us.codecraft.webmagic.Request;

import java.util.regex.Pattern;

/**
 * url正则表达式Request匹配规则
 *
 * @author qun.zheng
 * @create 2018/12/11
 **/
public class RequestRegexMathRule implements RequestMathRule{

    private final Pattern pattern;
    private String requestMethod = null;

    public RequestRegexMathRule(String urlRegex) {
        pattern = Pattern.compile(urlRegex);
    }

    @Override
    public boolean match(Request request) {
        return pattern.matcher(request.getUrl()).matches();
    }
}
