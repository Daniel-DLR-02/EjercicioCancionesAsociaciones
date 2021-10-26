package com.triana.salesianos.EjercicioSongs.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class AddedToPK implements Serializable {

    private Long playlist_id;

    private Long song_id;

}
