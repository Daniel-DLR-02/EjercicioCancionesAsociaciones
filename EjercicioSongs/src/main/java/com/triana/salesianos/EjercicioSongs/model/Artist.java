package com.triana.salesianos.EjercicioSongs.model;


import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
@Builder
public class Artist {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Song> songs = new ArrayList<>();

    public void addSong(Song s) {
        this.songs.add(s);
        s.setArtist(this);
    }

    public void removeSong(Song s) {
        this.songs.remove(s);
        s.setArtist(null);
    }
}
