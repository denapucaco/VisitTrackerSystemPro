package com.sparsh.tracker.visit.aspects;

import java.util.Map;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author prashant.swamy
 *
 */
@Aspect
@Component
public class LoggingAspect {

    private static final Logger LOGGER = Logger.getLogger(LoggingAspect.class);

    @Around("@annotation(com.sparsh.tracker.visit.aspects.Loggable) && @annotation(requestMapping) && args(model)")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint, RequestMapping requestMapping, Map<String, Object> model) {

        long startTime = System.currentTimeMillis();

        Object viewName = null;
        try {
            viewName = joinPoint.proceed();
        } catch (Throwable e) {
            LOGGER.error("Error: " + e.getMessage());
            model.put("error_message", "Service not available. Please try after some time.");
            viewName = "error";
        }

        String classMethodName = joinPoint.getSignature().toShortString();

        // StringBuilder requestMethodNames = new StringBuilder();
        // RequestMethod[] requestMethods = requestMapping.method();
        // for (RequestMethod requestMethod : requestMethods) {
        // requestMethodNames.append(requestMethod.name()).append(" ");
        // }

        StringBuilder valueNames = new StringBuilder();

        String[] values = requestMapping.value();
        for (String value : values) {
            valueNames.append(value).append(" ");
        }

        long endTime = System.currentTimeMillis();
        long timeTakenToExecute = endTime - startTime;

        LOGGER.info(classMethodName + " executed with URI value: " + valueNames.toString().trim() + " in " + timeTakenToExecute
                + " milli Seconds.");
        return viewName;
    }

}
