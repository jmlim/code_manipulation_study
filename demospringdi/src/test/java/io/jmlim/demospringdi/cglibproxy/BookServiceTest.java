package io.jmlim.demospringdi.cglibproxy;

import org.junit.Test;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class BookServiceTest {

    @Test
    public void di() {
        MethodInterceptor handler = new MethodInterceptor() {
            BookService bookService = new BookService();

            @Override
            public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {

                if (method.getName().equals("rent")) {
                    System.out.println("cglib 로 interface 를 이용하지 않고 바로 class를 프록싱111___앞");
                    Object invoke = method.invoke(bookService, args);
                    System.out.println("cglib 로 interface 를 이용하지 않고 바로 class를 프록싱2222___뒤");
                    return invoke;
                }

                return method.invoke(bookService, args);
            }
        };

        BookService bookService = (BookService) Enhancer.create(BookService.class, handler);
        Book book = new Book();

        book.setTitle("spring");
        bookService.rent(book);
    }
}