package com.triana.salesianos.EjercicioSongs.repository;

import com.triana.salesianos.EjercicioSongs.model.AddedTo;
import com.triana.salesianos.EjercicioSongs.model.AddedToPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddedToRepository
        extends JpaRepository<AddedTo, AddedToPK> {
}