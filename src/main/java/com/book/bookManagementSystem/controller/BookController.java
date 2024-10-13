package com.book.bookManagementSystem.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.book.bookManagementSystem.dto.BookDTO;
import com.book.bookManagementSystem.dto.DeleteBookResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.Update;
import org.springframework.http.HttpStatus;
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
    public List<BookDTO> getAllBooks() {
        return bookService.getAllBooks().stream()
                .map(book -> new BookDTO(
                        book.getTitle(),
                        book.getDescription(),
                        book.getAuthor(),
                        book.getGenre(),
                        book.getYearPublished()
                ))
                .collect(Collectors.toList());
    }

    @GetMapping("/author/{authorName}")
    public List<BookDTO> findBooksByAuthor(@PathVariable String authorName){
        return bookService.findBooksByAuthor(authorName).stream()
                .map(book -> new BookDTO(
                        book.getTitle(),
                        book.getDescription(),
                        book.getAuthor(),
                        book.getGenre(),
                        book.getYearPublished()
                ))
                .collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<BookDTO> createBook(@RequestBody BookDTO bookDTO){
        Book book = new Book();
        book.setTitle(bookDTO.getTitle());
        book.setDescription(bookDTO.getDescription());
        book.setAuthor(bookDTO.getAuthor());
        book.setGenre(bookDTO.getGenre());
        book.setYearPublished(bookDTO.getYearPublished());

        Book createdBook = bookService.createBook(book);

        return ResponseEntity.ok(new BookDTO(
                createdBook.getTitle(),
                createdBook.getDescription(),
                createdBook.getAuthor(),
                createdBook.getGenre(),
                createdBook.getYearPublished()
        ));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<DeleteBookResponseDTO> deleteBookById(@PathVariable String id) {
        boolean isDeleted = bookService.deleteBookById(id);

        if (isDeleted) {
            DeleteBookResponseDTO responseDTO = new DeleteBookResponseDTO("Book deleted", id);
            return ResponseEntity.ok(responseDTO);  // Return status 200 OK with the response DTO
        } else {
            DeleteBookResponseDTO responseDTO = new DeleteBookResponseDTO("Not found", id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseDTO);  // Return status 404 NOT FOUND with the response DTO
        }
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<BookDTO> updateBook(@PathVariable String id, @RequestBody BookDTO bookDTO){
        Book updatedBook = bookService.updateBook(id, bookDTO);
        if (updatedBook != null){
            BookDTO updatedBookDTO = new BookDTO(
                    updatedBook.getTitle(),
                    updatedBook.getDescription(),
                    updatedBook.getAuthor(),
                    updatedBook.getGenre(),
                    updatedBook.getYearPublished()
            );
            return ResponseEntity.ok(updatedBookDTO);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
