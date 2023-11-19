package std22079.librarymanagement;

import std22079.librarymanagement.Configuration.DatabaseConfiguration;
import std22079.librarymanagement.Repositories.*;
public class Main {
    public static void main(String[] args) {

        AuthorCrudOperations crudAuthors = new AuthorCrudOperations();
        BookCrudOperations crudBooks = new BookCrudOperations();
        SubscriberCrudOperations crudSubscriber = new SubscriberCrudOperations();

        System.out.println(crudBooks.findAll().toString());
        System.out.println(crudAuthors.findAll().toString());
        System.out.println(crudSubscriber.findAll().toString());

    }
}
