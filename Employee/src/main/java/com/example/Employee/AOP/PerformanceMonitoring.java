package com.example.Employee.AOP;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerformanceMonitoring {
      public static final Logger logger = LoggerFactory.getLogger(PerformanceMonitoring.class);
    
      @Around("execution(* com.example.Employee.Services.EmployeeServices.getallemployees(..))")
    public Object monitorTime(ProceedingJoinPoint jp) throws Throwable {
        // Performance monitoring logic goes here

        long startTime = System.currentTimeMillis();
        // Simulate method execution

        Object result = jp.proceed();
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;    
        logger.info(jp.getSignature().getName());
        logger.info("Method executed in " + duration+" milliseconds.");
        return result;
    }

}
