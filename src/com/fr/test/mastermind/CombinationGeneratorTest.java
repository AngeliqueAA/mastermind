package com.fr.test.mastermind;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

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

}
