package com.triana.salesianos.EjercicioSongs;

import com.triana.salesianos.EjercicioSongs.model.Artist;
import com.triana.salesianos.EjercicioSongs.model.Song;
import com.triana.salesianos.EjercicioSongs.service.ArtistService;
import com.triana.salesianos.EjercicioSongs.service.PlaylistService;
import com.triana.salesianos.EjercicioSongs.service.SongService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class mainDePrueba {

    private final SongService songService;
    private final ArtistService artistService;
    private final PlaylistService playlistService;

    @PostConstruct
    public void init(){

        Artist coldplay = Artist.builder()
                .name("Coldplay")
                .songs(new ArrayList<>())
                .build();

        artistService.save(coldplay);

        Song song1 = Song.builder()
                .title("Yellow")
                .album("Parachutes")
                .year("2000")
                .build();

        song1.addArtist(coldplay);

        songService.save(song1);

        System.out.printf("%s, %s\n", song1.getTitle(), song1.getArtist().getName());
        song1.deleteArtist(coldplay);
        songService.save(song1);
        System.out.printf("%s, %s\n", song1.getTitle(), song1.getArtist() != null ? song1.getArtist().getName() : "No artist");


    }


}
