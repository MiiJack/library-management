package std22079.librarymanagement;

import std22079.librarymanagement.Model.*;
import std22079.librarymanagement.Repositories.*;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        AuthorCrudOperations crudAuthors = new AuthorCrudOperations();
        BookCrudOperations crudBooks = new BookCrudOperations();
        SubscriberCrudOperations crudSubscriber = new SubscriberCrudOperations();

        System.out.println(crudBooks.findAll().toString());
        System.out.println(crudAuthors.findAll().toString());
        System.out.println(crudSubscriber.findAll().toString());

        Author author1 = new Author(1,"SwagMaster","M");
        Book book1 = new Book(4,"Smokilla",420, LocalDate.now(), author1, Book.Topic.COMEDY);

        crudAuthors.save(author1);
        crudBooks.save(book1);

    }
}
