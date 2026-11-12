package com.craft;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Pointcut("execution(* com.craft.StudentService.*(..))")
    public void studentServiceMethods() {}

    // 1. @Before Advice
    @Before("studentServiceMethods()")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("[AOP @Before] Calling method: " + joinPoint.getSignature().getName());
    }

    // 2. @After Advice
    @After("studentServiceMethods()")
    public void logAfter(JoinPoint joinPoint) {
        System.out.println("[AOP @After] Completed method: " + joinPoint.getSignature().getName());
    }

    // 3. @AfterReturning Advice
    @AfterReturning(
            pointcut = "execution(* com.craft.StudentService.getStudentTech(..))",
            returning = "result"
    )
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        System.out.println("[AOP @AfterReturning] Method returned value: " + result);
    }

    // 4. @AfterThrowing Advice
    @AfterThrowing(
            pointcut = "execution(* com.craft.StudentService.validateAge(..))",
            throwing = "ex"
    )
    public void logException(JoinPoint joinPoint, Throwable ex) {
        System.out.println("[AOP @AfterThrowing] Exception caught: " + ex.getMessage());
    }

    // 5. @Around Advice
    @Around("execution(* com.craft.StudentService.addStudent(..))")
    public Object measureExecutionTime(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println("[AOP @Around] Starting timer for " + pjp.getSignature().getName());

        Object output = pjp.proceed();

        long elapsed = System.currentTimeMillis() - start;
        System.out.println("[AOP @Around] Finished in " + elapsed + " ms");
        return output;
    }
}