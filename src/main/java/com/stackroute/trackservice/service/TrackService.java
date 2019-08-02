package com.stackroute.trackservice.service;

import com.stackroute.trackservice.domain.Track;

import java.util.List;

/**
 * TrackService Interface provides method declarations for all the operations supported
 * in the application.
 */
public interface TrackService {
    public Track saveTrack(Track track);
    public Track getTrackById(int id);
    public Track deleteTrackById(int id);
    public List<Track> getAllTracks();
    public Track updateTrack(int id,Track trackToUpdate);
    public List<Track> selectTrackByName(String trackName );
    }

