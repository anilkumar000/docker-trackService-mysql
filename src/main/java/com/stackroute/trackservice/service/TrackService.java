package com.stackroute.trackservice.service;

import com.stackroute.trackservice.domain.Track;

import java.util.List;

public interface TrackService {
    public Track saveTrack(Track track);
    public Track getTrackById(int id);
    public Track deleteTrackById(int id);
    public List<Track> getAllTracks();
    public Track updateTrack(int id,Track trackToUpdate);
    }

