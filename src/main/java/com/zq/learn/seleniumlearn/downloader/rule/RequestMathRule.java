package com.zq.learn.seleniumlearn.downloader.rule;

import us.codecraft.webmagic.Request;

/**
 * ${DESCRIPTION}
 *
 * @author qun.zheng
 * @create 2018/12/11
 **/
public interface RequestMathRule {
    RequestMathRule All = new RequestMathAllRule();
    
    boolean match(Request request);
}
