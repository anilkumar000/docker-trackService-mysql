package com.stackroute.trackservice.exceptions;

public class TrackNotFoundException extends Exception {
    String message;
    public TrackNotFoundException(){}
    public TrackNotFoundException(String message){
        super(message);
        this.message=message;
    }
}
