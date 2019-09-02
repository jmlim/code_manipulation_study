package io.jmlim.reflectionexam;

import java.util.Arrays;

public class App3 {

    public static void main(String[] args) {
        // 필드에 붙은 어노테이션 가져오기
        Arrays.stream(Book.class.getDeclaredFields()).forEach(f -> {
            System.out.println(f + "의 어노테이션 정보===============");
            Arrays.stream(f.getAnnotations()).forEach(anno -> {
                MyAnnotation myAnnotation = (MyAnnotation) anno;
                System.out.println(myAnnotation.value());
                System.out.println(myAnnotation.name());
                System.out.println(myAnnotation.number());
            });
            System.out.println(f + "의 어노테이션 정보 끝===============");
        });
    }
}
