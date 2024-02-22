package com.example.library_aop.aspect;

import com.example.library_aop.annotation.Performance;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PerformanceAspect {

    @Around("@annotation(performance)")
    public Object superviser(ProceedingJoinPoint joinPoint, Performance performance)
            throws Throwable {

        long start = System.currentTimeMillis();
        try {
            return joinPoint.proceed(joinPoint.getArgs());
        } finally {
            long end = System.currentTimeMillis();
            long duree = end - start;

                System.out.printf("Attention l'appel à %s à durée %dms %n",
                        joinPoint.toShortString(), duree);

        }
    }

}
