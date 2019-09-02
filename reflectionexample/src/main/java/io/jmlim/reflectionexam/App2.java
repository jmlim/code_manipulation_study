package io.jmlim.reflectionexam;

import java.util.Arrays;

public class App2 {

    public static void main(String[] args) {
        System.out.println("북============");
        Arrays.stream(Book.class.getAnnotations()).forEach(System.out::println);

        // 마이북
        // 만약 MyAnnotation 에 @Inherited 어노테이션을 붙일 경우 어노테이션도 상속이 되므로
        // 북에 붙어있는 어노테이션도 조회가 된다.
        System.out.println("마이북============");
        Arrays.stream(MyBook.class.getAnnotations()).forEach(System.out::println);

        // getDeclaredAnnotations 에 있는 어노테이션을 사용하면 MyBook 에 있는 어노테이션만 가져옴
        System.out.println("마이북=== getDeclaredAnnotations============");
        Arrays.stream(MyBook.class.getDeclaredAnnotations()).forEach(System.out::println);

    }
}
