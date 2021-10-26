package com.triana.salesianos.EjercicioSongs.model;


import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class Song {


    @Id
    @GeneratedValue
    private Long id;

    private String title;

    @ManyToOne(fetch = FetchType.EAGER)
    private Artist artist;

    private String album;

    private String year;

    @Builder.Default
    @OneToMany
    private List<AddedTo> addedTo = new ArrayList<>();

    public Song(Long id, String title, Artist artist, String album, String year) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.year = year;
    }
}
