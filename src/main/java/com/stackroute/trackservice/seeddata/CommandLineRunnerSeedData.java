package com.stackroute.trackservice.seeddata;

import com.stackroute.trackservice.domain.Track;
import com.stackroute.trackservice.exceptions.TrackAlreadyExistsException;
import com.stackroute.trackservice.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
/*
    * Class implements CommandLineRunner to get called after application context is
    * created and seeds data to the database.
        */
@Component
public class CommandLineRunnerSeedData implements CommandLineRunner {

   private TrackService trackService;

    @Autowired
    public CommandLineRunnerSeedData(TrackService trackService){
        this.trackService=trackService;
    }

    @Override
    public void run(String... args) throws Exception {
        Track track1=new Track(4,"Promise","Album by Chainsmokers");
        Track track2=new Track(5,"Beautiful","Album by Angemi Remix");
        Track track3=new Track(6,"Psycho","Album of Saaho");
        try {
            trackService.saveTrack(track1);
            trackService.saveTrack(track2);
            trackService.saveTrack(track3);
        }catch (TrackAlreadyExistsException ex){
            ex.printStackTrace();
        }

    }
}
