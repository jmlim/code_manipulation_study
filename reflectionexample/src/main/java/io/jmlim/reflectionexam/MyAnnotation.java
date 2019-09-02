package io.jmlim.reflectionexam;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
//애너테이션을 사용할 수 있는 위치, 타입하고 필드에만 가능
@Target({ElementType.TYPE, ElementType.FIELD})
// 어노테이션 상속
@Inherited
public @interface MyAnnotation {

    // primitive 타입의 레퍼런스 타입 또는 리스트를 필드로 가질 수 있다.
    //  기본값도 가질 수 있다.
    String name() default "jmlim";

    int number() default 100;

    String value();
}
