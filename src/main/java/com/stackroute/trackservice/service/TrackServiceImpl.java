package com.stackroute.trackservice.service;

import com.stackroute.trackservice.domain.Track;
import com.stackroute.trackservice.repostiory.TrackRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implements TrackService to provide basic insert, delete, get operations on Tracks
 */
@Service
public class TrackServiceImpl implements TrackService {
    TrackRepository trackRepository;

    public TrackServiceImpl(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    /**
     * Insert track into the database.
     * @Input Track to be inserted in the database
     * @Output Track created after inserting into the database.
     */
    @Override
    public Track saveTrack(Track track) {
        return trackRepository.save(track);

    }

    /**
     * Finds the track in the database using the trackId.
     * @Input ID of the track to get from database
     * @Output Track object
     */
    @Override
    public Track getTrackById(int id) {
        return trackRepository.findById(id).get();

    }

    /**
     * First checks the track is present in the database and stores in a Optional.
     * If the track is present then deletes the track in the database and return the track
     * else return null.
     * @Input Id of the track to be deleted.
     * @Output Track if deleted or null if the track is not found in the database.
     */
    @Override
    public Track deleteTrackById(int id) {
        trackRepository.delete(trackRepository.findById(id).get());
        return trackRepository.findById(id).get();

    }

/**
 * Returns all the tracks in the database.
 * @Output List of Tracks as List<Track>
*/
 @Override
    public List<Track> getAllTracks() {
        return trackRepository.findAll();

    }

    /**
     * Finds the Track by Id as a reference and updated it's fields and save's it.
     * @Input Id of the track to be updated
     * @Input Track object containing the updated details
     * @Output Updated track.
     */
 @Override
    public Track updateTrack(int id,Track trackToUpdate) {
        trackRepository.findById(id).get().setTrackName(trackToUpdate.getTrackName());
        trackRepository.findById(id).get().setComments(trackToUpdate.getComments());
        return trackRepository.save(trackRepository.findById(id).get());

    }

    @Override
    public List<Track> selectTrackByName(String trackname){
     List<Track> foundTracks=trackRepository.selectTrackByName(trackname);
     return foundTracks;
    }
}
