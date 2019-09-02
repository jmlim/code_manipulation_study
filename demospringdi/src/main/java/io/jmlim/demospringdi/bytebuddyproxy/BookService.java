package io.jmlim.demospringdi.bytebuddyproxy;

public class BookService {

    public void rent(Book book) {
        System.out.println("어떤책을 빌리나 : " + book.getTitle());
    }

    public void returnBook(Book book) {
        System.out.println("return book : " + book);
    }
}
