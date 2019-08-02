package com.stackroute.trackservice.seeddata;

import com.stackroute.trackservice.domain.Track;
import com.stackroute.trackservice.exceptions.TrackAlreadyExistsException;
import com.stackroute.trackservice.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class ApplicationListenerSeedData implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    TrackService trackService;
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        Track track1=new Track(1,"Promises","Album by Chainsmokers");
        Track track2=new Track(2,"Beautiful Life","Album by Angemi Remix");
        Track track3=new Track(3,"Psycho","Album of Saaho");
        try {
            trackService.saveTrack(track1);
            trackService.saveTrack(track2);
            trackService.saveTrack(track3);
        }catch (TrackAlreadyExistsException ex){
            ex.printStackTrace();
        }


    }
}
