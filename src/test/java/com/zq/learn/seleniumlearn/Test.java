package com.zq.learn.seleniumlearn;

import java.io.File;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {
        System.out.println(Pattern.matches("https://www\\.zhihu\\.com/question/\\w+",
                "https://www.zhihu.com/question/48510028"));

        System.out.println(new File(Test.class.getResource("/").getPath()).getPath());
    }
}
