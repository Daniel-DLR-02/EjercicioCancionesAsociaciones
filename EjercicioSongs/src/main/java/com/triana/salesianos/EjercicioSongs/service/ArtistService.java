package com.triana.salesianos.EjercicioSongs.service;

import com.triana.salesianos.EjercicioSongs.model.Artist;
import com.triana.salesianos.EjercicioSongs.repository.ArtistRepository;
import com.triana.salesianos.EjercicioSongs.service.base.BaseService;
import org.springframework.stereotype.Service;

@Service
public class ArtistService extends BaseService<Artist,Long, ArtistRepository> {
}
