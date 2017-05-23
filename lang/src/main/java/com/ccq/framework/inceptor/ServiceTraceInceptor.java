package com.ccq.framework.inceptor;
/**
 *  @author xiaoliu
 *
 */

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.ccq.framework.exception.AppException;
import com.ccq.framework.lang.Result;

@Component
@Order(512)
@Aspect
public class ServiceTraceInceptor implements MethodInterceptor {

    public static Logger logger = LoggerFactory.getLogger(ServiceTraceInceptor.class);

    @Around("@within(com.ccq.framework.annotation.ServiceTrace)")		//增加切入点，链接@ServiceTrace拦截的所有方法
    public Object methodInceptor(ProceedingJoinPoint pjp) {
        Object result = null;
        try {
            result = pjp.proceed();
            return result;
        } catch (Throwable ex) {
            Signature signature =  pjp.getSignature();
            Class returnType = ((MethodSignature) signature).getReturnType();
            logger.debug(ex.getStackTrace().toString());
            if(ex instanceof AppException) {
                //如果返回类型为com.ccq.framework.lang.Result,则转换为该类型
                if(returnType.equals(Result.class)) {
                    return new Result(false,ex.getMessage());
                }else
                    throw new AppException(((AppException) ex).getSuccess(),ex.getMessage());
            }else {
                if(returnType.equals(Result.class)) {
                    return new Result(false,ex.getMessage());
                }else {
                    logger.debug(ex.toString());
                    throw new AppException(false, ex.getMessage());
                }
            }
        }
    }

    public Object invoke(MethodInvocation arg0) throws Throwable {

        return null;
    }
}
