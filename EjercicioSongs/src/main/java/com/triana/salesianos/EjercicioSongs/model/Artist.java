package com.triana.salesianos.EjercicioSongs.model;


import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
@Builder
@Table(name = "artist")
public class Artist {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "artist")
    private List<Song> songs = new ArrayList<Song>();

    public Artist(String name){
        this.name=name;
    }
}
