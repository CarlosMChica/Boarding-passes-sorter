package com.carlosdelachica.boarding_passes_sorter.model;

public class BoardingPass {
    
    private String origin;
    private String destination;
    private String seat;
    private String transport;

    public BoardingPass(String origin, String destination, String seat, String transport) {
        this.origin = origin;
        this.destination = destination;
        this.seat = seat;
        this.transport = transport;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public String getSeat() {
        return seat;
    }

    public String getTransport() {
        return transport;
    }

}
