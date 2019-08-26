package com.cqupt.web.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

/**
 * 使用aspectJ代理数据校验
 */
@Aspect
@Component
public class BeanValidationAspect {


    /*最后一个参数为BindingResult类的方法*/
    /*设为第一个参数会出bug？？？？？不晓得*/
    @Pointcut("execution(* com.cqupt.web.controller.*.*(..,org.springframework.validation.BindingResult))")
    private static void pointCut() {}

    @Around("pointCut()")
    public Object checkBeanData(ProceedingJoinPoint joinPoint) throws Throwable {

        System.out.println("--------------进入校验切面---------------");

        Object[] args = joinPoint.getArgs();

        for (Object arg : args) {
            if (arg instanceof BindingResult) {
                int errorCount = ((BindingResult) arg).getErrorCount();
                if (errorCount != 0) {
                    //抛出参数不合法异常
                    throw new IllegalArgumentException("Illegal Argument Exception");
                }
                break;
            }
        }
        return joinPoint.proceed();
    }
}
