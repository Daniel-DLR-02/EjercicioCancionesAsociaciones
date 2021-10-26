package com.triana.salesianos.EjercicioSongs.model;


import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
@Builder
@NoArgsConstructor @AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class AddedTo {

    @Builder.Default
    @EmbeddedId
    private AddedToPK id = new AddedToPK();

    @CreatedDate
    private LocalDateTime dateTime;

    private int orden;

    @ManyToOne
    @MapsId("playlist_id")
    @JoinColumn(name = "playlist_id")
    private Playlist playlist;

    @ManyToOne
    @MapsId("song_id")
    @JoinColumn(name = "song_id")
    private Song song;

    public AddedTo(LocalDateTime dateTime, int orden) {
        this.dateTime = dateTime;
        this.orden = orden;
    }

    public void addSong(Song s){
        song = s;
        s.getAddedTo().add(this);
    }

    public void removeSong(Song s){
        s.getAddedTo().remove(this);
        song = null;
    }

    public void addPlaylist(Playlist p){
        playlist = p;
        p.getAddedTo().add(this);
    }

    public void removePlaylist(Playlist p){
        p.getAddedTo().remove(this);
        playlist = null;
    }


}
