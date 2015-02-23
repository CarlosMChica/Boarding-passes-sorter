package com.carlosdelachica.boarding_passes_sorter.model;

public class TrainBoardingPass extends BasicBoardingPass {

    private String trainNumber;
    private String seat;

    public TrainBoardingPass(String origin, String destination, String seat, String trainNumber) {
        super(origin, destination);
        this.seat = seat;
        this.trainNumber = trainNumber;
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public String getSeat() {
        return seat;
    }

}
