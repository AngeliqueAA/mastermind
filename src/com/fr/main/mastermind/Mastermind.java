package com.fr.main.mastermind;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Mastermind {

	List<Color> combinationToFind;

	public Mastermind(List<Color> combinationToFind) {
		this.combinationToFind = combinationToFind;
	}

	public void game() {

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

				int input = choices.nextInt();
				playerCombination.add(Color.values()[input]);
			}

			displaySeparator();
			System.out.println("User selection: " + playerCombination);

			GameResult result = playTurn(playerCombination);
			if (result.getWellPlacedColor() == 3) {
				success = true;
				displaySeparator();
				String successMessage = MessageFormat.format("SUCCESS in {0} turn(s)", gameTurn);
				System.out.println(successMessage);
				displaySeparator();
			} else {
				String displayGameResult = displayStringResult(result);
				System.out.println(displayGameResult);
			}
		}

		if (gameTurn == maxTurn && success == false) {
			displaySeparator();
			System.out.println("GAME OVER");
			String expectedResult = MessageFormat.format("WINNING COMBINATION WAS : {0}", combinationToFind);
			System.out.println(expectedResult);
			displaySeparator();
		}

		choices.close();
	}

	public GameResult playTurn(List<Color> combination) {

		List<Color> copyOfCombinationToFind = new ArrayList<Color>(combinationToFind);
		int wellPlacedColor = countWellPlacedColor(combination, copyOfCombinationToFind);
		int misplacedColor = countMisplacedColor(combination, copyOfCombinationToFind);

		return new GameResult(wellPlacedColor, misplacedColor);
	}

	public String displayStringResult(GameResult result) {

		String resultToDisplay = MessageFormat.format("{0} {1} {2} {3}", result.getWellPlacedColor(),
				ResultString.WELL_PLACED, result.getMisplacedColor(), ResultString.MISPLACED);
		return resultToDisplay;
	}

	private int countWellPlacedColor(List<Color> playerCombination, List<Color> combination) {
		int wellPlacedColor = 0;
		for (int i = playerCombination.size() - 1; i >= 0; i--) {
			if (playerCombination.get(i).equals(combination.get(i))) {
				combination.remove(i);
				playerCombination.remove(i);
				wellPlacedColor++;
			}
		}
		return wellPlacedColor;
	}

	private int countMisplacedColor(List<Color> playerCombination, List<Color> combination) {
		int misplacedColor = 0;
		for (int i = playerCombination.size() - 1; i >= 0; i--) {

			if (combination.contains(playerCombination.get(i))) {
				combination.remove(playerCombination.get(i));
				misplacedColor++;
			}
		}
		return misplacedColor;

	}

	private void displaySeparator() {
		System.out.println("--------------------------------------------------------------");
	}

}
