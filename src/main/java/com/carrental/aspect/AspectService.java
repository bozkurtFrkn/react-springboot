package com.carrental.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectService {
    @Before("execution(* com.carrental.service.*.save(..))")
    public void beforeServicesSaveMethod(JoinPoint joinPoint){
        System.out.println("Kullanilacak servis = " + joinPoint.getTarget());
        System.out.println(joinPoint.getSignature());
    }
}
