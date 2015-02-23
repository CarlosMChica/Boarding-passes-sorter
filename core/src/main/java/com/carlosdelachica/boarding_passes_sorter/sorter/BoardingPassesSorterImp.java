package com.carlosdelachica.boarding_passes_sorter.sorter;

import com.carlosdelachica.boarding_passes_sorter.model.BasicBoardingPass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BoardingPassesSorterImp implements BoardingPassesSorter {

    private Map<String, BasicBoardingPass> originsMap = new HashMap<>();
    private Map<BasicBoardingPass, String> destinationsMap = new HashMap<>();
    private List<BasicBoardingPass> sortedBasicBoardingPasses;
    private BasicBoardingPass departureBasicBoardingPass;


    @Override
    public List<BasicBoardingPass> sort(List<BasicBoardingPass> basicBoardingPasses) {
        if (basicBoardingPasses == null || basicBoardingPasses.size() == 0) {
            return new ArrayList<>();
        }
        init(basicBoardingPasses);
        findDepartureBoardingPass();
        sortTripBoardingPasses();
        return sortedBasicBoardingPasses;
    }

    private void init(List<BasicBoardingPass> basicBoardingPasses) {
        sortedBasicBoardingPasses = new ArrayList<>();
        for (BasicBoardingPass basicBoardingPass : basicBoardingPasses) {
            String origin = basicBoardingPass.getOrigin();
            String destination = basicBoardingPass.getDestination();
            originsMap.put(origin, basicBoardingPass);
            destinationsMap.put(basicBoardingPass, destination);
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
        departureBasicBoardingPass = originsMap.remove(departureCity);
        sortedBasicBoardingPasses.add(departureBasicBoardingPass);
    }

    private void sortTripBoardingPasses() {
        String nextCity = departureBasicBoardingPass.getDestination();
        do {
            BasicBoardingPass basicBoardingPass = originsMap.remove(nextCity);
            sortedBasicBoardingPasses.add(basicBoardingPass);
            nextCity = basicBoardingPass.getDestination();
        } while (originsMap.size() > 0);
    }

}
