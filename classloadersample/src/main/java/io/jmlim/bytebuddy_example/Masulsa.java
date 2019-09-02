package io.jmlim.bytebuddy_example;

import java.io.IOException;

public class Masulsa {

    public static void main(String[] args) throws IOException {

/*
        ClassLoader classLoader = Masulsa.class.getClassLoader();
        TypePool typePool = TypePool.Default.of(classLoader);

        new ByteBuddy().redefine(
                typePool
                        .describe("io.jmlim.bytebuddy_example.Moja").resolve(), ClassFileLocator.ForClassLoader.of(classLoader)
        )
                .method(named("pullOut"))
                .intercept(FixedValue.value("Rabbit!!"))
                .make().saveIn(new File("C:/dev/git/classloadersample/target/classes"));
*/

        System.out.println(new Moja().pullOut());
    }
}
