package io.jmlim.demospringdi.dynamicproxy;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class BookServiceTest {

    /**
     * 다이나믹 프록시
     * - 런타임에 특정 인터페이스 들을 구현하는 클래스
     * <p>
     * 다이나믹 프록시를 이용해 프록시 인스턴스 만들기
     */
    BookService bookService = (BookService) Proxy.newProxyInstance(BookService.class.getClassLoader(), new Class[]{BookService.class},
            new InvocationHandler() {
                BookService bookService = new DefaultBookService();

                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                    if (method.getName().equals("rent")) {
                        System.out.println("다이나믹 프록싱111___앞");
                        Object invoke = method.invoke(bookService, args);
                        System.out.println("다이나믹 프록싱222___뒤");
                        return invoke;
                    }

                    return method.invoke(bookService, args);
                }
            });

    @Test
    public void di() {
        Book book = new Book();
        book.setTitle("spring");
        bookService.rent(book);
    }
}