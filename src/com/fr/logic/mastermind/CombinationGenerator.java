package com.fr.logic.mastermind;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.fr.shared.mastermind.Color;

public class CombinationGenerator {

	final int NUMBER_OF_COLOR_TO_GUESS = 3;

	public Color translateToColor(Integer translateToColor) {
		Color translatedColor = Color.values()[translateToColor];
		return translatedColor;
	}

	public List<Color> generateRandomArrayOfColor() {

		List<Color> arrayOfRandomColor = new ArrayList<Color>();
		Random random = new Random();
		int maxColorValue = 4;

		for (int i = 0; i < NUMBER_OF_COLOR_TO_GUESS; i++) {
			arrayOfRandomColor.add(translateToColor(random.nextInt(maxColorValue)));
		}

		return arrayOfRandomColor;
	}

}
