package com.book.bookManagementSystem.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.book.bookManagementSystem.model.Book;

@Repository
public interface BookRepository extends MongoRepository<Book, String> {

}
