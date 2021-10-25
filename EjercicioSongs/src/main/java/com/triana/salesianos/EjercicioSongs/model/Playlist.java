package com.triana.salesianos.EjercicioSongs.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
@Table(name = "playlist")
public class Playlist {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String description;

}
