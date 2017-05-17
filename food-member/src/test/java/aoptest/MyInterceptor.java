package aoptest;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * 切面
 * @author Bird
 *
 */
@Aspect
public class MyInterceptor {

    @Pointcut("execution(* PersonServiceBean.*(..))")
    private void anyMethod(){}//定义一个切入点

    @Around("@within(com.ccq.framework.annotation.ServiceTrace)")
    public void monitorAround(ProceedingJoinPoint pjp) throws Throwable {

        System.out.println("method start time:" + System.currentTimeMillis());

        Object re = pjp.proceed();

        System.out.println("method end time:" + System.currentTimeMillis());

    }

    @AfterReturning("anyMethod()")
    public void doAfter(){
        System.out.println("后置通知");
    }

    @After("anyMethod()")
    public void after(){
        System.out.println("最终通知");
    }

    @AfterThrowing("anyMethod()")
    public void doAfterThrow(){
        System.out.println("例外通知");
    }
}