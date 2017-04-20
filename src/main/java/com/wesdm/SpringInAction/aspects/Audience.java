package com.wesdm.SpringInAction.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Audience {

	@Pointcut("execution(** com.wesdm.SpringInAction.aspects.Performance.perform(..))")
	public void perform() {
	}

	@Before("performance()")
	public void silenceCellPhones() {
		System.out.println("Silencing cell phones");
	}

	@Before("performance()")
	public void takeSeats() {
		System.out.println("Taking seats");
	}

	@AfterReturning("performance()")
	public void applause() {
		System.out.println("CLAP CLAP CLAP!!!");
	}

	@AfterThrowing("performance()")
	public void demandRefund() {
		System.out.println("Demanding a refund");
	}

	@After("performance()")
	public void afterParty() {

	}

	@Around("performance()")
	public void haveBeer(ProceedingJoinPoint jp) {
		try {
			System.out.println("Silencing cell phones");
			System.out.println("Taking seats");
			jp.proceed();									//can be invoked multiple times, use case retry method call if fail
			System.out.println("CLAP CLAP CLAP!!!");
		} catch (Throwable e) {
			System.out.println("Demanding a refund");
		}
	}
}
