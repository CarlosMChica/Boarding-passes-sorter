package com.carlosdelachica.boarding_passes_sorter.model;

public class BasicBoardingPass {
    
    private String origin;
    private String destination;

    public BasicBoardingPass(String origin, String destination) {
        this.origin = origin;
        this.destination = destination;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

}
