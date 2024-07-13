package com.example.spoticloudspringdata.services;


import com.example.spoticloudspringdata.entities.Artist;
import com.example.spoticloudspringdata.entities.Genre;
import com.example.spoticloudspringdata.repositories.ArtistRepository;
import com.example.spoticloudspringdata.repositories.GenreRepository;
import com.example.spoticloudspringdata.schemas.ArtistDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistService {
    private final ArtistRepository artistRepository;
    private final GenreRepository genreRepository;

    public ArtistService(ArtistRepository artistRepository, GenreRepository genreRepository) {
        this.artistRepository = artistRepository;
        this.genreRepository = genreRepository;
    }

    public List<ArtistDto> getAllArtists() {
        return artistRepository.findAll().stream().map(ArtistDto::new).toList();
    }
    public Artist createArtist(ArtistDto artist) {
        Artist newArtist = new Artist(artist.getName(), artist.getType(), artist.getDescription(), artist.getCountry());
        Genre genre = genreRepository.findByName(artist.getGenre());
        newArtist.setGenre(genre);
        return artistRepository.save(newArtist);
    }
}
