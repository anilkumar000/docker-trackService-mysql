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
    @PostMapping("track")
    public ResponseEntity<?> saveTrack(@RequestBody Track track) {
        System.out.println(track);
        Track savedTrack=trackService.saveTrack(track);
        System.out.println(savedTrack);
        return new ResponseEntity<>(savedTrack, HttpStatus.OK);
    }
    @GetMapping("track")
    public ResponseEntity<?> getTrackById(@RequestParam int id)
    {
        Track foundTrackById=trackService.getTrackById(id);
        return new ResponseEntity<>(foundTrackById,HttpStatus.OK);
    }
    @DeleteMapping("track")
    public ResponseEntity<?> deleteTrackById(@RequestParam int id) {
        trackService.deleteTrackById(id);
        return new ResponseEntity<>(trackService.getTrackById(id),HttpStatus.OK);
    }
    @GetMapping("track/all")
    public ResponseEntity<?> getAllTracks() {
        List<Track> listOfTracks=trackService.getAllTracks();
        return new ResponseEntity<>(listOfTracks,HttpStatus.OK);
    }

    @PutMapping("track")
    public ResponseEntity<?> updateTrack(@RequestParam int id, @RequestBody Track trackToUpdate) {
        Track updatedTrack=trackService.updateTrack(id,trackToUpdate);
        return new ResponseEntity<>(updatedTrack,HttpStatus.OK);
    }

}
