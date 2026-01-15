package com.example.Employee.AOP;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.example.Employee.Entity.Employee;

@Aspect
@Component
public class Validation {

    private static final Logger logger = LoggerFactory.getLogger(Validation.class);

    @Around("execution(* com.example.Employee.Services.EmployeeServices.addEmployee(..))")
    public Object validateEmployee(ProceedingJoinPoint jp) throws Throwable {

        Object[] args = jp.getArgs();

        if (args.length == 0 || !(args[0] instanceof Employee)) {
            throw new RuntimeException("Invalid method arguments");
        }

        Employee employee = (Employee) args[0];

        // 🔎 Validation logic
        if (employee.getFirstname() == null || employee.getFirstname().isBlank()) {
            throw new RuntimeException("First name cannot be empty");
        }

        if (employee.getEmail() == null || employee.getEmail().isBlank()) {
            throw new RuntimeException("Email cannot be empty");
        }

        logger.info("Validation passed for employee: {}", employee.getFirstname());

        // ✅ Proceed with original method
        return jp.proceed();
    }
}
