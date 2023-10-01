package ru.ikudryashov.springaop.aop;

import org.aspectj.lang.annotation.Pointcut;

public class Pointcuts {

    @Pointcut("execution (* ru.ikudryashov.springaop.services.BookService.get*(..))")
    public void allGetMethods() {

    }

    @Pointcut("execution (* ru.ikudryashov.springaop.services.BookService.add*(..))")
    public void allAddMethods() {

    }
}
