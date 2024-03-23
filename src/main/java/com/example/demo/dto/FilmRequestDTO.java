package com.example.demo.dto;

public class FilmRequestDTO {
    private String title;
    private Long genreId;

    // getter and setter
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public Long getGenreId() {
        return genreId;
    }
    public void setGenreId(Long genreId) {
        this.genreId = genreId;
    }
}
