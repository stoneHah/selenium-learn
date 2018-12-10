package com.zq.learn.seleniumlearn.expression;


import org.springframework.util.StringUtils;

public class JSExpression implements Expression {
    private String expression;

    public JSExpression(String expression) {
        this.expression = expression;
    }

    @Override
    public String getExpression() {
        if (StringUtils.hasText(expression)) {
            return StringUtils.replace(expression, "\n", "");
        }
        return "";
    }

    public static void main(String[] args) {
    }
}
