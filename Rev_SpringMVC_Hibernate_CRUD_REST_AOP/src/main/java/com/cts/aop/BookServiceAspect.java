package com.cts.aop;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BookServiceAspect {
	
	//Aspect - cross cutting module eg: BookServiceAspect 
	//JointPoint - Join point always represents a method execition
	//ADVICE - @before / @After / @Around
	//Pointcut - execution(* com.cts.service.BookServiceIpl.listAllBooks(..))

		@Before("execution(* com.cts.service.BookServiceImpl.listAllBooks(..))")
		public void beforeAdvice(JoinPoint joinPoint) {
			System.out.println("Before, Data going to fetched on "+ new Date()+ "Using method "+joinPoint.getSignature().getName());
		}
		
		@After("execution(* com.cts.service.BookServiceImpl.listAllBooks(..))")
		public void afterAdvice(JoinPoint joinPoint) {
			System.out.println("After, Data going to fetched on "+ new Date()+ "Using method "+joinPoint.getSignature().getName());
		}
		
		
}
