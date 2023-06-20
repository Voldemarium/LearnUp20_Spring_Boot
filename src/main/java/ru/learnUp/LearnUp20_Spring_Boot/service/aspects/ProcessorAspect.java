package ru.learnUp.LearnUp20_Spring_Boot.service.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect     // это аннотация не Spring, а из фрамеворка AspectJ
@Component  //  поэтому добавляем аннотацию @Component, чтобы Spring принял этот бин
public class ProcessorAspect {

    private static final Logger log = LoggerFactory.getLogger(ProcessorAspect.class);

// @Pointcut - точка среза для любых методов внутри процессоров с любыми типами параметров .processors.*.*(..)
    @Pointcut("execution(* ru.learnUp.LearnUp20_Spring_Boot.service.processors.*.*(..))")
    public void callInProcessorsPath() {
    }

    //до предыдущего метода callInProcessorsPath()
    @Before("callInProcessorsPath()")
    public void beforeCall(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            log.info("arg: {}", arg);
        }
        Object target = joinPoint.getTarget();
        Object thiss= joinPoint.getThis();
        log.info("{}", target);
        log.info("{}", thiss);
    }

    @Around("callInProcessorsPath()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("Before execute {}", joinPoint.toString());
        Object result = joinPoint.proceed();
        log.info("After execute {}", result);
        return result;
    }

   @Before("@annotation(ru.learnUp.LearnUp20_Spring_Boot.service.registry.Calculable)")  //выполняется перед методами,
    // помеченными аннотацией @Calculable
    public void beforeAnnotation(JoinPoint joinPoint) {
         log.info("Calculating! {}", joinPoint);
    }
}
