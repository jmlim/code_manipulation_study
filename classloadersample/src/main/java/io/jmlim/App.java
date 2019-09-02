package io.jmlim;

/**
 * Hello world!
 */
public class App {
    Book book = new Book();

    static String name = "jmlim";

    static {
        name = "jmlim";
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");

        ClassLoader classLoader = App.class.getClassLoader();
        System.out.println(classLoader);
        System.out.println(classLoader.getParent());
        System.out.println(classLoader.getParent().getParent());
    }
}
