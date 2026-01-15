package com.example.Employee.AOP;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
    public static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);
    

    // return type class name method name ,(arguments)
   //advice            //pointcut
    @Before("execution(* com.example.Employee.Services.EmployeeServices.deleteEmployee(..))")
    public void logInfo(JoinPoint jp) {
        logger.info("Before method executed successfully."+ jp.getSignature().getName());
    }
    @AfterThrowing("execution(* com.example.Employee.Services.EmployeeServices.deleteEmployee(..))")
    public void logInfoExecutedThrow(JoinPoint jp) {
        logger.info("Method Throw error."+ jp.getSignature().getName());
    }
    @After("execution(* com.example.Employee.Services.EmployeeServices.deleteEmployee(..))")
    public void logInfoExecuted(JoinPoint jp) {
        logger.info("After Method executed ."+ jp.getSignature().getName());
    }
    @AfterReturning("execution(* com.example.Employee.Services.EmployeeServices.deleteEmployee(..))")
    public void logInfoExecutedSuccessfully(JoinPoint jp) {
        logger.info("AfterReturning Method executed successfully."+ jp.getSignature().getName());
    }
    
}
