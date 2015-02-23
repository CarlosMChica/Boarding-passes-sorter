package com.carlosdelachica.boarding_passes_sorter.sorter;

import com.carlosdelachica.boarding_passes_sorter.model.BoardingPass;

import java.util.List;

public interface BoardingPassesSorter {
    List<BoardingPass> sort(List<BoardingPass> boardingPasses);
}
