package io.jmlim.demospringdi.proxypattern;

public interface BookService {

    void rent(Book book);

    void returnBook(Book book);
}
