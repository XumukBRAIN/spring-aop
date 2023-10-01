package ru.ikudryashov.springaop.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import ru.ikudryashov.springaop.entities.Book;
import ru.ikudryashov.springaop.utils.CustomResponse;
import ru.ikudryashov.springaop.utils.CustomStatus;

import java.util.Collections;

@Component
@Aspect
@Slf4j
public class MyAspect {

    //TODO Написать Advice для get-методов

    @Around("ru.ikudryashov.springaop.aop.Pointcuts.allAddMethods()")
    public Object aroundAddingAdvice(ProceedingJoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Book book = new Book();
        if (signature.getName().equals("addBook")) {
            Object[] args = joinPoint.getArgs();
            for (Object arg: args) {
                if (arg instanceof Book) {
                    book = (Book) arg;
                    log.info("Попытка добавить книгу с названием {}", ((Book) arg).getTitle());
                }
            }
        }

        Object result;
        try {
            result = joinPoint.proceed();
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
            result = new CustomResponse<>(Collections.emptyList(), CustomStatus.EXCEPTION);
        }

        log.info("Книга с названием {} добавлена", book.getTitle());
        return result;
    }
}
