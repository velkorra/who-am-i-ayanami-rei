package com.example.spoticloudspringdata.entities;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "playlist")
public class Playlist extends BaseEntity {
    private String name;
    private int ownerId;
    private boolean isPrivate;
    private Timestamp dateCreated;
    private String description;
    private Set<TrackPlaylist> tracks;

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "owner_id", nullable = false)
    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    @Column(name = "is_private", nullable = false)
    public boolean isPrivate() {
        return isPrivate;
    }

    public void setPrivate(boolean aPrivate) {
        isPrivate = aPrivate;
    }

    @Column(name = "date_created", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    public Timestamp getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Timestamp dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    @OneToMany(mappedBy = "playlist")
    public Set<TrackPlaylist> getTracks() {
        return tracks;
    }

    public void setTracks(Set<TrackPlaylist> tracks) {
        this.tracks = tracks;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}