package com.example.demo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
//@Component
public class LogsInterceptor {

    @Before("execution(* com.example.demo.impl.service.EmployeeInfrastructureImpl.*(..))")
    public void getAllAdvice1(){
        System.out.println("Service method getter called");
    }

//    @Pointcut("execution(public * *(..))")
//    public void getAllAdvice2(){
//        System.out.println("Service method getter called");
//    }
//
//    @Pointcut("execution(public String createNewEmployee(..))")
//    public void getNamePointcut(){
//        System.out.println("Service method getter called");
//    }

    @Around("execution(* com.example.demo.impl.service.EmployeeInfrastructureImpl.*(..))")
    public Object employeeAroundAdvice(ProceedingJoinPoint proceedingJoinPoint){
        System.out.println("Before invoking getName() method");
        Object value = null;
        try {
            value = proceedingJoinPoint.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        System.out.println("After invoking getName() method. Return value="+value);
        return value;
    }
}

