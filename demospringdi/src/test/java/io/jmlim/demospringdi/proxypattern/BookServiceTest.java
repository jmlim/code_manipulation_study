package io.jmlim.demospringdi.proxypattern;

import org.junit.Test;

public class BookServiceTest {

    //BookService bookService = new DefaultBookService();
    BookService bookService = new BookServiceProxy(new DefaultBookService());

    @Test
    public void di() {
        Book book = new Book();
        book.setTitle("spring");
        bookService.rent(book);
    }
}