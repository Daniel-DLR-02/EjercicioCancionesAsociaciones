package com.triana.salesianos.EjercicioSongs.service;

import com.triana.salesianos.EjercicioSongs.model.Playlist;
import com.triana.salesianos.EjercicioSongs.repository.PlaylistRepository;
import com.triana.salesianos.EjercicioSongs.service.base.BaseService;
import org.springframework.stereotype.Service;

@Service
public class PlaylistService extends BaseService<Playlist,Long, PlaylistRepository> {
}
