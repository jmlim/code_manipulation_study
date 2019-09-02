package io.jmlim.demospringdi.bytebuddyproxy;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.InvocationHandlerAdapter;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static net.bytebuddy.matcher.ElementMatchers.named;

/**
 * 클래스를 사용하여 프록시를 구현할경우
 * 파이날 클래스나 프라이빗 클라스(하위 클래스에서는 상위 클래스를 실행함) 로
 * 상속을 막아버리면 구현이 안되므로 주의
 * <p>
 * 복잡해지면 인터페이스를 만들어서 관리하는게 좋다.
 */
public class BookServiceTest {

    @Test
    public void di() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Class<? extends BookService> proxyClass = new ByteBuddy()
                .subclass(BookService.class)
                .method(named("rent")).intercept(InvocationHandlerAdapter.of(new InvocationHandler() {
                    BookService bookService = new BookService();

                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                        System.out.println("[바이트 버디 사용] interface 를 이용하지 않고 바로 class를 프록싱___앞");
                        Object invoke = method.invoke(bookService, args);
                        System.out.println("[바이트 버디 사용] interface 를 이용하지 않고 바로 class를 프록싱111___앞");
                        return null;
                    }
                }))
                .make().load(BookService.class.getClassLoader()).getLoaded();

        BookService bookService = proxyClass.getConstructor(null).newInstance();

        Book book = new Book();
        book.setTitle("스프링");
        bookService.rent(book);
        bookService.returnBook(book);
    }
}