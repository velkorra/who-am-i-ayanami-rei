package com.example.spoticloudspringdata.services;

import com.example.spoticloudspringdata.entities.Genre;
import com.example.spoticloudspringdata.repositories.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService {
    private final GenreRepository genreRepository;

    @Autowired
    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    public Genre findByName(String name) {
        return genreRepository.findByName(name);
    }
    public List<Genre> getAllGenres() {
        return genreRepository.findAll();
    }
}
