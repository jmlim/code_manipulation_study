package io.jmlim.demospringdi.proxypattern;

public class BookServiceProxy implements BookService {
    private BookService bookService;

    public BookServiceProxy(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public void rent(Book book) {
        System.out.println("11111");
        bookService.rent(book);
        System.out.println("2222");
    }

    @Override
    public void returnBook(Book book) {
        System.out.println("return ~~~ 111");
        bookService.returnBook(book);
        System.out.println("return ~~~ 222");
    }
}
