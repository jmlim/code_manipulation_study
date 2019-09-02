package io.jmlim.demospringdi.dynamicproxy;


public class DefaultBookService implements BookService {
    @Override
    public void rent(Book book) {
        System.out.println("어떤책을 빌리나 : "+ book.getTitle());
    }

    @Override
    public void returnBook(Book book) {
        System.out.println("return book : " + book);
    }
}
