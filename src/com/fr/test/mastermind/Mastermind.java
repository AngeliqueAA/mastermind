package com.fr.test.mastermind;

import java.util.List;

public class Mastermind {
	List<Color> combinationToFind;

	public Mastermind(List<Color> combinationToFind) {
		this.combinationToFind = combinationToFind; // TODO Auto-generated constructor stub
	}

	public int play(List<Color> combination) {
		int wellPlacedColor = 0;
		for (int i = 0; i < combination.size(); i++) {
			if (combination.get(i).equals(combinationToFind.get(i))) {
				wellPlacedColor++;
			}
		}
		return wellPlacedColor;
	}

}
