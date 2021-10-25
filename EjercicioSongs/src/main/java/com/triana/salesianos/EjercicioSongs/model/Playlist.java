package com.triana.salesianos.EjercicioSongs.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(joinColumns = @JoinColumn(name = "playlist_id",
            foreignKey = @ForeignKey(name="FK_SONG_PLAYLIST")),
            inverseJoinColumns = @JoinColumn(name = "song_id",
                    foreignKey = @ForeignKey(name="FK_PLAYLIST_SONG")),
            name = "playlist"
    )
    private List<Song> songs = new ArrayList<>();

    public void addSong(Song s) {
        if (this.getSongs() == null)
            this.setSongs(new ArrayList<>());
        this.getSongs().add(s);

        if (s.getPlaylists() == null)
            s.setPlaylists(new ArrayList<>());
        s.getPlaylists().add(this);
    }

    public void removeSong(Song s) {
        s.getPlaylists().remove(this);
        this.getSongs().remove(s);
    }

}
