package com.example.demo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
@Aspect
public class AopConfig {
    @Around("@within(org.springframework.web.bind.annotation.RestController)")
    public Object simbleAop(final ProceedingJoinPoint pjp)  {
        Object[] obj=pjp.getArgs();
        System.out.println("obj = [" + Arrays.asList(obj) + "]");
        Object o= null;
        try {
            o = pjp.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("pjp = [" + o + "]");
        return o;
    }
}
