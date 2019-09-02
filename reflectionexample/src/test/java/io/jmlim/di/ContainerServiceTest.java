package io.jmlim.di;

import org.junit.Test;

import static org.junit.Assert.*;

public class ContainerServiceTest {

    @Test
    public void getObject_BookRepository() {
        BookRespository bookRepository = ContainerService.getObject(BookRespository.class);
        assertNotNull(bookRepository);
    }


    @Test
    public void getObject_BookService() {
        BookService bookService = ContainerService.getObject(BookService.class);
        assertNotNull(bookService);
        assertNotNull(bookService.bookRespository);

    }


}