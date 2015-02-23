package com.carlosdelachica.boarding_passes_sorter.sorter;

import com.carlosdelachica.boarding_passes_sorter.model.BasicBoardingPass;

import java.util.List;

public interface BoardingPassesSorter {
    List<BasicBoardingPass> sort(List<BasicBoardingPass> basicBoardingPasses);
}
