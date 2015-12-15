package com.shawn.demo.aspect;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Shawn on 2015/12/11.
 */
@Aspect
public class WebLayerAspect {

    private Logger logger = LogManager.getLogger(this.getClass());

    private Gson gson = new GsonBuilder().serializeNulls().create();

    @Pointcut("within(com.shawn.demo.controller.*)")
    public void webLayer() {

    }

    @Before("webLayer()")
    public void beforeMethod(JoinPoint joinpoint) {
        String methodName = joinpoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinpoint.getArgs());
        System.out.println("前置通知：The method "+ methodName +" begins with " + args);
        logger.info("before.......");
    }

    @After("webLayer()")
    public void afterMethod(JoinPoint joinpoint) {
        String methodName = joinpoint.getSignature().getName();
        logger.info(methodName + "completed, time: " + System.currentTimeMillis());
    }

    @AfterReturning(value = "webLayer()", returning = "result")
    public void afterReturning(JoinPoint joinpoint, Object result) {
        logger.info("Result: " + result);
    }
}
