package com.zq.learn.seleniumlearn;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class JsExpressionParserTest {

    @Test
    public void testExpressionParse() throws ScriptException, NoSuchMethodException {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");

        engine.eval("function aa(){\n" +
                "\tvar urls = [];\n" +
                "\tfor(var i = 1;i < 5;i++){\n" +
                "\t\turls.push('http://angularjs.cn/?p=' + i);\n" +
                "\t}\n" +
                "\treturn urls;\n" +
                "}\n");

        Invocable invocable = (Invocable) engine;
        Object urls = invocable.invokeFunction("aa");

        System.out.println(JSON.toJSONString(urls));

    }
}
