package com.stackroute.trackservice.repostiory;

import com.stackroute.trackservice.domain.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface to perform database operations with a dynamic DB
 */
@Repository
public interface TrackRepository extends JpaRepository<Track,Integer> {
}