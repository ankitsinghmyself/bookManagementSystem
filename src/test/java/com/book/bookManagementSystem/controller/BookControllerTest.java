package com.book.bookManagementSystem.controller;

import com.book.bookManagementSystem.controller.BookController;
import com.book.bookManagementSystem.dto.DeleteBookResponseDTO;
import com.book.bookManagementSystem.service.BookService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
public class BookControllerTest {

    @Mock
    private BookService bookService;

    @InjectMocks
    private BookController bookController;

    // Test case for successful deletion
    @Test
    public void testDeleteBookById_Success() {
        // Arrange
        String bookId = "12345";
        when(bookService.deleteBookById(bookId)).thenReturn(true);

        // Act
        ResponseEntity<DeleteBookResponseDTO> response = bookController.deleteBookById(bookId);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("Book deleted", response.getBody().getMessage());
        assertEquals(bookId, response.getBody().getBookId());
    }

    // Test case for deletion failure (book not found)
    @Test
    public void testDeleteBookById_NotFound() {
        // Arrange
        String bookId = "12345";
        when(bookService.deleteBookById(bookId)).thenReturn(false);

        // Act
        ResponseEntity<DeleteBookResponseDTO> response = bookController.deleteBookById(bookId);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("Not found", response.getBody().getMessage());
        assertEquals(bookId, response.getBody().getBookId());
    }
}
