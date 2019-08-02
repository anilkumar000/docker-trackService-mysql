package com.stackroute.trackservice.controller;

import com.stackroute.trackservice.domain.Track;
import com.stackroute.trackservice.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class TrackController {
    TrackService trackService;
    @Autowired
    public TrackController(TrackService trackService) {
        this.trackService = trackService;
    }

    /**
     * Insert track into the database
     * @Input Track to be inserted
     * @Output Newly created track
     */
    @PostMapping("track")
    public ResponseEntity<?> saveTrack(@RequestBody Track track) {
        System.out.println(track);
        Track savedTrack=trackService.saveTrack(track);
        System.out.println(savedTrack);
        return new ResponseEntity<>(savedTrack, HttpStatus.OK);
    }

    /**
     * Search Track
     * @Input id Id of the track
     * @Output Track
     */
    @GetMapping("track/{id}")
    public ResponseEntity<?> getTrackById(@PathVariable int id)
    {
        Track foundTrackById=trackService.getTrackById(id);
        return new ResponseEntity<>(foundTrackById,HttpStatus.OK);
    }

    /**
     * Delete track by ID
     * @Input  Track Id to be deleted
     * @Output Deleted Track
     */
    @DeleteMapping("track")
    public ResponseEntity<?> deleteTrackById(@RequestParam int id) {
        trackService.deleteTrackById(id);
        return new ResponseEntity<>(trackService.getTrackById(id),HttpStatus.OK);
    }

    /**
     * Get all tracks
     * @Output All tracks in the database
     */
    @GetMapping("track")
    public ResponseEntity<?> getAllTracks() {
        List<Track> listOfTracks=trackService.getAllTracks();
        return new ResponseEntity<>(listOfTracks,HttpStatus.OK);
    }

    /**
     * Update Track by Id.
     * @Input Id of the track to be updated.
     * @pOutput Track object containing updated track details.
     * @return Updated track
     */
    @PutMapping("track")
    public ResponseEntity<?> updateTrack(@RequestParam int id, @RequestBody Track trackToUpdate) {
        Track updatedTrack=trackService.updateTrack(id,trackToUpdate);
        return new ResponseEntity<>(updatedTrack,HttpStatus.OK);
    }

}
