package com.book.bookManagementSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.bookManagementSystem.model.Book;
import com.book.bookManagementSystem.repository.BookRepository;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public Book updateBook(String id, Book bookDetails) {
        return bookRepository.findById(id).map(existingBook  -> {
            if (bookDetails.getTitle() != null){
                existingBook .setTitle(bookDetails.getTitle());
            }
            if (bookDetails.getDescription() != null){
                existingBook .setDescription(bookDetails.getDescription());
            }
            if (bookDetails.getAuthor() != null){
                existingBook .setAuthor(bookDetails.getAuthor());
            }
            if (bookDetails.getGenre() != null){
                existingBook .setGenre(bookDetails.getGenre());
            }
            if (bookDetails.getYearPublished() != null){
                existingBook .setYearPublished(bookDetails.getYearPublished());
            }
            return bookRepository.save(existingBook);
        }).orElse(null);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book createBook(Book book) {
        return bookRepository.save(book); // save to mongo
    }

    public boolean deleteBookById(String id) {
        if(bookRepository.existsById(id)){
         bookRepository.deleteById(id);
         return true;
        }
        return false;
    }
}
