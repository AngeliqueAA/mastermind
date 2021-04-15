package com.fr.main.mastermind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fr.logic.mastermind.ProcessGame;
import com.fr.shared.mastermind.Color;

public class StartGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Color> combinationToFind = new ArrayList<Color>(Arrays.asList(Color.ORANGE, Color.BLUE, Color.RED));
		ProcessGame processGame = new ProcessGame(combinationToFind);

		processGame.game();

		// mastermind.game();
	}

}
