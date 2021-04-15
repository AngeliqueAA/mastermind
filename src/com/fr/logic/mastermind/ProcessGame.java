package com.fr.logic.mastermind;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.fr.shared.mastermind.Color;

public class ProcessGame {

	private List<Color> randomCombinationToFind;
	private List<Color> playerCombination;

	public ProcessGame(List<Color> randomCombinationToFind) {

		this.randomCombinationToFind = randomCombinationToFind;
	}

	public List<Color> getRandomCombinationToFind() {
		return randomCombinationToFind;
	}

	public List<Color> getPlayerCombination() {
		return playerCombination;
	}

	public void game() {
		Mastermind mastermind = new Mastermind(randomCombinationToFind);

		boolean success = false;

		int gameTurn = 0;
		int maxTurn = 0;

		System.out.println("########## START ##########");
		System.out.println("YOU HAVE TO FIND 3 COLORS EMPLACEMENT TO WIN !");
		Scanner choices = new Scanner(System.in);
		System.out.println("Number of game turn : ");
		maxTurn = choices.nextInt();

		while (!success && gameTurn < maxTurn) {
			List<Color> playerCombination = new ArrayList<Color>();

			gameTurn++;

			displaySeparator();
			for (int index = 0; index < 3; index++) {
				String colorExplanation = "RED = 0, GREEN = 1, YELLOW = 2, ORANGE = 3, BLUE = 4";
				System.out.println(colorExplanation);
				String message = MessageFormat.format("COLOR EMPLACEMENT {0}:", index);
				System.out.println(message);

				int colorChoosed = choices.nextInt();
				playerCombination.add(Color.values()[colorChoosed]);
			}

			displaySeparator();
			System.out.println("User selection: " + playerCombination);

			GameResult result = mastermind.playTurn(playerCombination);
			if (result.getWellPlacedColor() == 3) {
				success = true;
				displaySeparator();
				String successMessage = MessageFormat.format("SUCCESS in {0} turn(s)", gameTurn);
				System.out.println(successMessage);
				displaySeparator();
			} else {
				String displayGameResult = mastermind.displayStringResult(result);
				System.out.println(displayGameResult);
			}
		}

		if (gameTurn == maxTurn && success == false) {
			displaySeparator();
			System.out.println("GAME OVER");
			String expectedResult = MessageFormat.format("WINNING COMBINATION WAS : {0}", randomCombinationToFind);
			System.out.println(expectedResult);
			displaySeparator();
		}

		choices.close();
	}

	private void displaySeparator() {
		System.out.println("--------------------------------------------------------------");
	}

}
