package com.example.demo.service;

import com.example.demo.dto.GenreDTO;
import com.example.demo.model.GenreModel;
import com.example.demo.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GenreService {
    @Autowired
    private GenreRepository genreRepository;

    public List<GenreDTO> getAllGenres() {
        List<GenreModel> genres = genreRepository.findAll();
        return genres.stream().map(this::mapToDTO).collect(Collectors.toList());
    }
    // untuk getById 
    public GenreDTO getGenreById(Long id) {
        GenreModel genre = genreRepository.findById(id).orElseThrow(() -> new RuntimeException("Genre not found"));
        return mapToDTO(genre);
    }
    // tambah
    public GenreDTO createGenre(GenreDTO genreDTO) {
        GenreModel genre = new GenreModel();
        genre.setName(genreDTO.getName());
        genre = genreRepository.save(genre);
        return mapToDTO(genre);
    }
    // ubah
    public GenreDTO updateGenre(Long id, GenreDTO genreDTO) {
        GenreModel genre = genreRepository.findById(id).orElseThrow(() -> new RuntimeException("Genre not found"));
        // kode untuk merubah data
        genre.setName(genreDTO.getName());
        // setelah terubah kita akan menyimpannya
        genre = genreRepository.save(genre);
        return mapToDTO(genre);
    }
    // dellet
    public void deleteGenre(Long id) {
        genreRepository.deleteById(id);
    }
    // mapping
    private GenreDTO mapToDTO(GenreModel genre) {
        GenreDTO dto = new GenreDTO();
        dto.setId(genre.getId());
        dto.setName(genre.getName());
        return  dto;
    }
}
