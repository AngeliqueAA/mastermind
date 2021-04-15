package com.fr.test.mastermind;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.fr.shared.mastermind.Color;

public class CombinationGenerator {

	public Color translateToColor(Integer translateToColor) {
		Color translatedColor = Color.values()[translateToColor];
		return translatedColor;
	}

	public List<Color> generateRandomArrayOfColor() {

		List<Color> arrayOfRandomColor = new ArrayList<Color>();
		Random random = new Random();
		int maxColorValue = 4;

		Color generatedColor = translateToColor(random.nextInt(maxColorValue));
		arrayOfRandomColor.add(generatedColor);

		return arrayOfRandomColor;
	}

}
