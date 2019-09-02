package io.jmlim.reflectionexam;

import java.lang.reflect.Modifier;
import java.util.Arrays;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws ClassNotFoundException {
        // type
        Class<Book> bookClass = Book.class;

        // class instance
        //Book book = new Book();
        //Class<? extends Book> aClass = book.getClass();

        // text
        //Class<?> aClass1 = Class.forName("io.jmlim.Book");

        // 이 메소드는 접근제어자가 퍼블릭만 가져온다.
        Arrays.stream(bookClass.getFields()).forEach(System.out::println);

        // declared fields 가 접근제어자 관련없이 다 가져온다.
        Arrays.stream(bookClass.getDeclaredFields()).forEach(System.out::println);

        System.out.println();
        Book book = new Book();
        // 값을 가져올땐 인스턴스가 있어야한다.
        Arrays.stream(bookClass.getDeclaredFields()).forEach(f -> {
            try {
                f.setAccessible(true);
                System.out.printf("%s %s\n", f, f.get(book));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });

        System.out.println();

        // 메소드
        System.out.println("메서드==============");
        Arrays.stream(bookClass.getMethods()).forEach(System.out::println);

        //생성자
        System.out.println("생성자==============");
        Arrays.stream(bookClass.getDeclaredConstructors()).forEach(System.out::println);

        // 상위클래스
        System.out.println("슈퍼클래스==============");
        System.out.println(MyBook.class.getSuperclass());

        // 인터페이스
        System.out.println("인터페이스==============");
        Arrays.stream(MyBook.class.getInterfaces()).forEach(System.out::println);

        // modifiers
        System.out.println("모디파이어를 통해 스태틱인지 private 인지 확인 가능");

        Arrays.stream(Book.class.getDeclaredFields()).forEach(f -> {
            int modifiers = f.getModifiers();
            System.out.println("========================");
            System.out.println(f);
            System.out.println(Modifier.isPrivate(modifiers));
            System.out.println(Modifier.isPublic(modifiers));
            System.out.println("========================");
            System.out.println(Modifier.isStatic(modifiers));
        });
    }
}
