package com.book.bookManagementSystem.dto;

public class DeleteBookResponseDTO {
    private String message;
    private String bookId;

    // Constructor
    public DeleteBookResponseDTO(String message, String bookId) {
        this.message = message;
        this.bookId = bookId;
    }

    // Getters and Setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }
}
