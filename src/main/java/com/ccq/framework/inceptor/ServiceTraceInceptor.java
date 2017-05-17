package com.ccq.framework.inceptor;
/**
 *  @author xiaoliu
 *  
 *  ҵ������������
 *  
 */

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.ccq.framework.exception.AppException;
import com.ccq.framework.lang.Result;

@Component
@Aspect
public class ServiceTraceInceptor implements MethodInterceptor{

	public static Logger logger = LoggerFactory.getLogger(ServiceTraceInceptor.class);
	
	@Around("@within(com.ccq.framework.annotation.ServiceTrace)")
	public Object methodInceptor(ProceedingJoinPoint pjp) {
		Object result = null;
		try {
			result = pjp.proceed();
		} catch (Throwable ex) {
			if(ex instanceof AppException) {
				logger.debug(ex.toString());
				Result r = new Result(false,((AppException)ex).getMessage(),((AppException)ex).getCode());
				if(result instanceof Result) {
					return r;
				}
				return r;
			}else {
				logger.debug(ex.toString());
				Result r = new Result(false,"���ݷ����쳣","DATA_ACCESS_EXCEPTION");
				return r;
			}
		}
		
		return result;
	}

	@Override
	public Object invoke(MethodInvocation arg0) throws Throwable {
		
		
		return null;
	}
}
