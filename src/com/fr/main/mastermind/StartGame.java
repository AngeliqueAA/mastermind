package com.fr.main.mastermind;

import java.util.List;

import com.fr.logic.mastermind.CombinationGenerator;
import com.fr.logic.mastermind.ProcessGame;
import com.fr.shared.mastermind.Color;

public class StartGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CombinationGenerator combinationGenerator = new CombinationGenerator();
		List<Color> combinationToFind = combinationGenerator.generateRandomArrayOfColor();
		ProcessGame processGame = new ProcessGame(combinationToFind);

		processGame.game();

	}

}
