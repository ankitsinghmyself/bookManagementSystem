package com.book.bookManagementSystem.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import com.book.bookManagementSystem.model.Book;

import java.util.List;

@Repository
public interface BookRepository extends MongoRepository<Book, String> {
    // No need to add methods unless you want custom queries e.g. List<Book> findByAuthor(String author);

    @Query("{ 'author' : {$regex: ?0, $options: 'i' } }")
    List<Book> findByAuthorContaining(String author);
}
