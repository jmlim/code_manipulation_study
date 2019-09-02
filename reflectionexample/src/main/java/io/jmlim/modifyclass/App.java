package io.jmlim.modifyclass;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class App {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Class<?> bookClass = Class.forName("io.jmlim.modifyclass.Book");
        //Constructor<?> constructor = bookClass.getConstructor(null);
        Constructor<?> constructor = bookClass.getConstructor(String.class);
        //  Book book = (Book) constructor.newInstance();
        Book book = (Book) constructor.newInstance("myBook");
        System.out.println(book);

        // 조작
        Field a = Book.class.getDeclaredField("A");
        System.out.println(a.get(null));
        a.set(null, "aaaaaAAAA");
        System.out.println(a.get(null));


        System.out.println();

        // 값이 B인 필드는 private 이므로 setAccessible 를 true 로 주고 작업한다.
        Field b = Book.class.getDeclaredField("B");
        b.setAccessible(true);
        System.out.println(b.get(book));
        b.set(book, "BBBBBBBB");
        System.out.println(b.get(book));

        // private method 가져오기
        Method c = Book.class.getDeclaredMethod("c");
        c.setAccessible(true);
        c.invoke(book);

        // public method 가져오기. (integer 두개를 받는 메소드라 두가지의 타입 넘김)
        Method sum = Book.class.getDeclaredMethod("sum", int.class, int.class);
        // 리턴값이 있던 메소드
        int invoke = (int) sum.invoke(book, 1, 2);
        System.out.println(invoke);

    }
}
