package com.carlosdelachica.boarding_passes_sorter.sorter;

import com.carlosdelachica.boarding_passes_sorter.model.BoardingPass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BoardingPassesSorterImp implements BoardingPassesSorter {

    private Map<String, BoardingPass> originsMap = new HashMap<>();
    private Map<BoardingPass, String> destinationsMap = new HashMap<>();
    private List<BoardingPass> sortedBoardingPasses;
    private BoardingPass departureBoardingPass;


    @Override
    public List<BoardingPass> sort(List<BoardingPass> boardingPasses) {
        if (boardingPasses == null || boardingPasses.size() == 0) {
            return new ArrayList<>();
        }
        init(boardingPasses);
        findDepartureBoardingPass();
        sortTripBoardingPasses();
        return sortedBoardingPasses;
    }

    private void init(List<BoardingPass> boardingPasses) {
        sortedBoardingPasses = new ArrayList<>();
        for (BoardingPass boardingPass : boardingPasses) {
            String origin = boardingPass.getOrigin();
            String destination = boardingPass.getDestination();
            originsMap.put(origin, boardingPass);
            destinationsMap.put(boardingPass, destination);
        }
    }

    private void findDepartureBoardingPass() {
        String departureCity = null;
        for (String originCity : originsMap.keySet()) {
            if (!destinationsMap.containsValue(originCity)) {
                departureCity = originCity;
                break;
            }
        }
        departureBoardingPass = originsMap.remove(departureCity);
        sortedBoardingPasses.add(departureBoardingPass);
    }

    private void sortTripBoardingPasses() {
        String nextCity = departureBoardingPass.getDestination();
        do {
            BoardingPass boardingPass = originsMap.remove(nextCity);
            sortedBoardingPasses.add(boardingPass);
            nextCity = boardingPass.getDestination();
        } while (originsMap.size() > 0);
    }

}
