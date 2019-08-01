package com.stackroute.trackservice.service;

import com.stackroute.trackservice.domain.Track;
import com.stackroute.trackservice.repostiory.TrackRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TrackServiceImpl implements TrackService {
    TrackRepository trackRepository;

    public TrackServiceImpl(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    @Override
    public Track saveTrack(Track track) {
        return trackRepository.save(track);

    }

    @Override
    public Track getTrackById(int id) {
        return trackRepository.findById(id).get();

    }

    @Override
    public Track deleteTrackById(int id) {
        trackRepository.delete(trackRepository.findById(id).get());
        return trackRepository.findById(id).get();

    }

    @Override
    public List<Track> getAllTracks() {
        return null;
    }

    @Override
    public Track updateTrack() {
        return null;
    }
}
