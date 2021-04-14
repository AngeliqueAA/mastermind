package com.fr.main.mastermind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StartGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Color> combinationToFind = new ArrayList<Color>(Arrays.asList(Color.ORANGE, Color.BLUE, Color.RED));
		Mastermind mastermind = new Mastermind(combinationToFind);

		mastermind.game();
	}

}