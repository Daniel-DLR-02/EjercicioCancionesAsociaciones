package com.triana.salesianos.EjercicioSongs.repository;

import com.triana.salesianos.EjercicioSongs.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository
        extends JpaRepository<Song,Long> {
}
