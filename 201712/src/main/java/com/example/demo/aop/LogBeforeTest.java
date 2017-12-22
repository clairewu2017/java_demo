package com.example.demo.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * Created by chunmei on 12/21/2017.
 */
@Aspect
public class LogBeforeTest {
    @Before("execution(* Test.Case1(..))")
    public void BeforeMyTest(){
        System.out.println("Before call MyTest");
    }
}
