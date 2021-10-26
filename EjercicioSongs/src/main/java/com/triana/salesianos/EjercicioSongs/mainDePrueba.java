package com.triana.salesianos.EjercicioSongs;

import com.triana.salesianos.EjercicioSongs.model.AddedTo;
import com.triana.salesianos.EjercicioSongs.model.Artist;
import com.triana.salesianos.EjercicioSongs.model.Playlist;
import com.triana.salesianos.EjercicioSongs.model.Song;
import com.triana.salesianos.EjercicioSongs.service.AddedToService;
import com.triana.salesianos.EjercicioSongs.service.ArtistService;
import com.triana.salesianos.EjercicioSongs.service.PlaylistService;
import com.triana.salesianos.EjercicioSongs.service.SongService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class mainDePrueba {

    private final SongService songService;
    private final ArtistService artistService;
    private final PlaylistService playlistService;
    private final AddedToService addedToService;

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
        Song song2 = Song.builder()
                .title("Scientist")
                .album("A Rush of Blood to the Head.")
                .year("2002")
                .build();

        songService.save(song1);
        songService.save(song2);

        coldplay.addSong(song1);
        coldplay.addSong(song2);

        artistService.save(coldplay);

        Playlist playlist1 = Playlist.builder()
                .name("Coldplay-Playlist")
                .description("Una playlist de canciones de Colplay")
                .songs(new ArrayList<>())
                .build();
        playlist1.getSongs().add(song1);
        playlist1.getSongs().add(song2);

        playlistService.save(playlist1);

        AddedTo addedTo1 = AddedTo.builder()
                .orden(1)
                .dateTime(LocalDateTime.now())
                .playlist(playlist1)
                .song(song1)
                .build();

        addedToService.save(addedTo1);

        for(Artist art:artistService.findAll()) {
            System.out.printf("%s %s \n", art.getName(), art.getSongs());
        }

        for(Song sng:songService.findAll()) {
            System.out.printf("%s %s %s %s \n", sng.getTitle(), sng.getYear(), sng.getAlbum(), sng.getArtist());
        }
        for(Artist art:artistService.findAll()) {
            System.out.printf("%s %s \n", art.getName(), art.getSongs());
        }

        for(Playlist pl:playlistService.findAll()) {
            System.out.printf("%s %s  \n",pl.getName(), pl.getDescription());
        }

        playlistService.
                findAll()
                .forEach(p->p.getSongs().forEach(x-> System.out.printf("Lista de canciones de Playlist1: %s %s %s\n", x.getTitle(), x.getAlbum(), x.getYear())));

        for(AddedTo at: addedToService.findAll())
            System.out.printf(" Fecha de creacion:%s  Orden:%s  NombrePlaylist:%s  NombreCancion:%s\n", at.getDateTime(), at.getOrden(), at.getPlaylist().getName(), at.getSong().getTitle());
    }


}
