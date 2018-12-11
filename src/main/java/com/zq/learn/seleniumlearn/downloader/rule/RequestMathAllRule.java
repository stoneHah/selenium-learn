package com.zq.learn.seleniumlearn.downloader.rule;

import us.codecraft.webmagic.Request;

/**
 * ${DESCRIPTION}
 *
 * @author qun.zheng
 * @create 2018/12/11
 **/
public class RequestMathAllRule implements RequestMathRule {
    @Override
    public boolean match(Request request) {
        return true;
    }
}
