package com.stone.learn.seleniumlearn;

public class JsonTest {
    public static void main(String[] args) {
        String str = "\\\"vvv";
        System.out.println(str.replaceAll("\\\\\"","\""));
    }
}
