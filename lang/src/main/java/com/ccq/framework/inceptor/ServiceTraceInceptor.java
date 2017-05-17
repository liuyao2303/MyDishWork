package com.ccq.framework.inceptor;
/**
 *  @author xiaoliu
 *  
 */

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import com.ccq.framework.exception.AppException;
import com.ccq.framework.lang.Result;

@Component
@Aspect
public class ServiceTraceInceptor implements MethodInterceptor, Ordered {

	public static Logger logger = LoggerFactory.getLogger(ServiceTraceInceptor.class);

	@Around("@within(com.ccq.framework.annotation.ServiceTrace)")		//增加切入点，链接@ServiceTrace拦截的所有方法
	public Object methodInceptor(ProceedingJoinPoint pjp) {
		Object result = null;
		try {
			result = pjp.proceed();
		} catch (Throwable ex) {
			if(ex instanceof AppException) {
				throw new AppException(((AppException) ex).getSuccess(),ex.getMessage());
			}else {
				logger.debug(ex.toString());
				Result r = new Result(false,"DATA_ACCESS_EXCEPTION","DATA_ACCESS_EXCEPTION");
				return r;
			}
		}
		
		return result;
	}

	public Object invoke(MethodInvocation arg0) throws Throwable {
		
		
		return null;
	}

	/**
	 * 返回较大的order，保证事物能够正常回滚
	 * @return
	 */
	public int getOrder() {
		return 890317;
	}
}
