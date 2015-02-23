package com.carlosdelachica.boarding_passes_sorter.model;

public class PlaneBoardingPass extends BasicBoardingPass {

    private String gate;
    private String flightNumber;
    private String seat;
    private String baggageInfo;

    public PlaneBoardingPass(String origin, String destination, String seat, String gate, String flightNumber, String baggageInfo) {
        super(origin, destination);
        this.seat = seat;
        this.gate = gate;
        this.flightNumber = flightNumber;
        this.baggageInfo = baggageInfo;
    }

    public String getGate() {
        return gate;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getSeat() {
        return seat;
    }

    public String getBaggageInfo() {
        return baggageInfo;
    }

}
