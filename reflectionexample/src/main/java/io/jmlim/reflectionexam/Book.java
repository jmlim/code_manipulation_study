package io.jmlim.reflectionexam;

@MyAnnotation("정묵")
public class Book {

    private static String B = "BOOK";

    private static final String C = "BOOK";

    private String a;

    @MyAnnotation(value = "필드의 어노테이션 1", name = "림정묵")
    public String d = "d";

    @MyAnnotation(value = "필드의 어노테이션 2", number = 12)
    protected String e = "e";

    public Book() {
    }

    public Book(String a, String d, String e) {
        this.a = a;
        this.d = d;
        this.e = e;
    }

    private void f() {
        System.out.println("F");
    }

    public void g() {
        System.out.println("g");
    }

    public int h() {
        return 100;
    }
}
