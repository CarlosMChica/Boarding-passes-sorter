package com.carlosdelachica.boarding_passes_sorter.model;

public class BusBoardingPass extends BasicBoardingPass {

    private String busName;

    public BusBoardingPass(String origin, String destination, String busName) {
        super(origin, destination);
        this.busName = busName;
    }

    public String getBusName() {
        return busName;
    }

}
