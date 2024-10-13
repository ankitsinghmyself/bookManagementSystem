package com.book.bookManagementSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.Update;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.book.bookManagementSystem.model.Book;
import com.book.bookManagementSystem.service.BookService;

@RestController
@RequestMapping("/api/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    @PostMapping
    public Book createBook(@RequestBody Book book){
        return bookService.createBook(book);
    }

    @DeleteMapping("/delete/{id}")
    public  String deleteBookById(@PathVariable String id ){
        boolean isDeleted = bookService.deleteBookById(id);
        if(isDeleted){
            return "Book deleted" + id;
        }else{
            return  "Not found" + id;
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable String id, @RequestBody Book bookDetails){
        Book updatedBook = bookService.updateBook(id, bookDetails);
        if (updatedBook != null){
            return ResponseEntity.ok(updatedBook);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
