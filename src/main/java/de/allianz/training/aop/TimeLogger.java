package de.allianz.training.aop;


import lombok.extern.java.Log;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Component;

import java.util.logging.Level;

@Aspect
@Log
@Component
public class TimeLogger {


    private static final String LOGGING_MESSAGE = "method {} in class {} took {} milliseconds to execute";
    /**
     * around returns JoinPoint
     * @return
     */
    @Around("bean(toDoController)")
    public Object logControllerExeTime(ProceedingJoinPoint joinPoint) throws Throwable {
        Long start = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        Long end = System.currentTimeMillis();

        Long difference = end - start;

        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().getName();

        log.log(Level.INFO, className + " : " + methodName + " : " + difference);
        return proceed;
    }


}
