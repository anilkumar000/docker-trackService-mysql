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
        return trackRepository.findAll();

    }

    @Override
    public Track updateTrack(int id,Track trackToUpdate) {
        trackRepository.findById(id).get().setTrackName(trackToUpdate.getTrackName());
        trackRepository.findById(id).get().setComments(trackToUpdate.getComments());
        return trackRepository.save(trackRepository.findById(id).get());

    }
}
