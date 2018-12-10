package com.zq.learn.seleniumlearn.expression.resolver;


import com.zq.learn.seleniumlearn.expression.Expression;
import com.zq.learn.seleniumlearn.expression.JSExpression;

/**
 * 表达式解析器
 */
public class ExpressionResolver {
    public Expression resolve(String exp) {
        return new JSExpression(exp);
    }
}
