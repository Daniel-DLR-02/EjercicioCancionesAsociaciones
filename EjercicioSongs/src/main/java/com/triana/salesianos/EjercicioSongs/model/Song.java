package com.triana.salesianos.EjercicioSongs.model;


import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
@Table(name = "song")
public class Song {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    @ManyToOne
    private Artist artist;

    private String album;

    private String year;

    @ManyToMany(mappedBy = "songs", fetch = FetchType.EAGER)
    private List<Playlist> playlists;

    public void addArtist(Artist art) {
        this.artist=art;
        art.getSongs().add(this);
    }

    public void deleteArtist(Artist art) {
        art.getSongs().remove(this);
        this.artist = null;
    }

}
