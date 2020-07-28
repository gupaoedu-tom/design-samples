package com.gupaoedu.vip.pattern.decorator.loggs;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;

import java.util.Arrays;

/**
 * Created by Tom.
 */
public class JsonLogger extends LoggerDecorator {
    public JsonLogger(Logger logger) {
        super(logger);
    }

    @Override
    public void info(String s) {
        JSONObject result = composeBasicJsonResult();
        result.put("MESSAGE",s);
        logger.info(result.toString());
    }

    @Override
    public void error(String s) {
        JSONObject result = composeBasicJsonResult();
        result.put("MESSAGE",s);
        logger.error(result.toString());
    }

    public void error(Exception e) {
        JSONObject result = composeBasicJsonResult();
        result.put("EXCEPTION",e.getClass().getName());
        String exTrace = Arrays.toString(e.getStackTrace());
        result.put("STACKTRACE",exTrace);
        logger.error(result.toString());
    }

    private JSONObject composeBasicJsonResult(){
        return new JSONObject();
    }
}
