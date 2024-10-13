package com.book.bookManagementSystem.service;

import java.util.List;
import java.util.Optional;

import com.book.bookManagementSystem.dto.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.bookManagementSystem.model.Book;
import com.book.bookManagementSystem.repository.BookRepository;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public Book updateBook(String id, BookDTO bookDetailsDTO) {
        Optional<Book> existingBookOpt = bookRepository.findById(id);
        if (existingBookOpt.isPresent()){
            Book existingBook = existingBookOpt.get();

            existingBook.setTitle(bookDetailsDTO.getTitle());
            existingBook.setDescription(bookDetailsDTO.getDescription());
            existingBook.setAuthor(bookDetailsDTO.getAuthor());
            existingBook.setGenre(bookDetailsDTO.getGenre());
            existingBook.setYearPublished(bookDetailsDTO.getYearPublished());
            return bookRepository.save(existingBook);
        }
        return null;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public List<Book> findBooksByAuthor(String author){
        return bookRepository.findByAuthorContaining(author);
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
