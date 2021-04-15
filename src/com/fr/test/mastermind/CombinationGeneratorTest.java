package com.fr.test.mastermind;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.fr.logic.mastermind.CombinationGenerator;
import com.fr.shared.mastermind.Color;

class CombinationGeneratorTest {

	@Test
	void shouldReturnRedOnIntegerZero() {

		// given an integer
		CombinationGenerator combinationGenerator = new CombinationGenerator();
		Integer translateToColor = 0;

		// when we check the integer
		Color generatedColor = combinationGenerator.translateToColor(translateToColor);

		// then integer have to match with a color
		assertEquals(Color.RED, generatedColor);
	}

	@Test
	void shouldReturnGreenOnIntegerOne() {

		// given an integer
		CombinationGenerator combinationGenerator = new CombinationGenerator();
		Integer translateToColor = 1;

		// when we check the integer
		Color generatedColor = combinationGenerator.translateToColor(translateToColor);

		// then integer have to match with a color
		assertEquals(Color.GREEN, generatedColor);
	}

	@Test
	void shouldReturnYellowOnIntegerTwo() {

		// given an integer
		CombinationGenerator combinationGenerator = new CombinationGenerator();
		Integer translateToColor = 2;

		// when we check the integer
		Color generatedColor = combinationGenerator.translateToColor(translateToColor);

		// then integer have to match with a color
		assertEquals(Color.YELLOW, generatedColor);
	}

	@Test
	void shouldReturnAnArrayOfThreeColors() {

		// given an array of color
		CombinationGenerator combinationGenerator = new CombinationGenerator();
		List<Color> firstColorsToGuess = combinationGenerator.generateRandomArrayOfColor();

		// when we check the length
		int sizeOfArrayofColor = firstColorsToGuess.size();

		// then length integer have to be 3
		assertEquals(3, sizeOfArrayofColor);
	}

	@Test
	void shouldReturnAnArrayOfThreeRandomColor() {

		// given an array of color
		CombinationGenerator combinationGenerator = new CombinationGenerator();
		List<Color> firstColorsToGuess = combinationGenerator.generateRandomArrayOfColor();

		// when we generate another array of color
		List<Color> secondColorsToGuess = combinationGenerator.generateRandomArrayOfColor();

		// then the two arrays have to be different
		assertNotEquals(firstColorsToGuess, secondColorsToGuess);
	}

}
