package com.triana.salesianos.EjercicioSongs.service;

import com.triana.salesianos.EjercicioSongs.model.Song;
import com.triana.salesianos.EjercicioSongs.repository.SongRepository;
import com.triana.salesianos.EjercicioSongs.service.base.BaseService;
import org.springframework.stereotype.Service;

@Service
public class SongService extends BaseService<Song,Long, SongRepository> {
}
