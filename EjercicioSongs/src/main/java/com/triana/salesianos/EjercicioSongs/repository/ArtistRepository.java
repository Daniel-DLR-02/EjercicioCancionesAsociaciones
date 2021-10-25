package com.triana.salesianos.EjercicioSongs.repository;

import com.triana.salesianos.EjercicioSongs.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRepository
        extends JpaRepository<Artist,Long> {
}
