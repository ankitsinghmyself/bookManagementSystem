package com.book.bookManagementSystem.dto;

public class BookDTO {
    private String title;
    private String description;
    private String author;
    private String genre;
    private Integer yearPublished;

    public BookDTO(String title, String description, String author, String genre, Integer yearPublished){
        this.title = title;
        this.author = author;
        this.description = description;
        this.genre = genre;
        this.yearPublished = yearPublished;
    }
    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public String getDescription(){
        return description;
    }
    public void  setDescription(String description){
        this.description = description;
    }
    public String getAuthor(){
        return author;
    }
    public void setAuthor(String author){
        this.author = author;
    }
    public String getGenre(){
        return genre;
    }
    public void setGenre(String genre){
        this.genre = genre;
    }
    public Integer getYearPublished(){
        return yearPublished;
    }
    public void setYearPublished(Integer yearPublished){
        this.yearPublished = yearPublished;
    }
}
