package com.triana.salesianos.EjercicioSongs.repository;

import com.triana.salesianos.EjercicioSongs.model.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaylistRepository
        extends JpaRepository<Playlist,Long> {
}
