package com.triana.salesianos.EjercicioSongs.service;


import com.triana.salesianos.EjercicioSongs.model.AddedTo;
import com.triana.salesianos.EjercicioSongs.model.AddedToPK;
import com.triana.salesianos.EjercicioSongs.repository.AddedToRepository;
import com.triana.salesianos.EjercicioSongs.service.base.BaseService;
import org.springframework.stereotype.Service;

@Service
public class AddedToService
        extends BaseService<AddedTo, AddedToPK, AddedToRepository> {
}