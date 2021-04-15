package com.fr.logic.mastermind;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import com.fr.shared.mastermind.Color;
import com.fr.shared.mastermind.ResultString;

public class Mastermind {

	List<Color> combinationToFind;

	public Mastermind(List<Color> combinationToFind) {
		this.combinationToFind = combinationToFind;
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

}
