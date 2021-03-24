package com.fr.test.mastermind;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

class mastermindTest {

	@Test
	void shouldMatchCombinationForOneColor() {
		List<Color> combinationToFind = Collections.singletonList(Color.BLUE);

		// given
		Mastermind mastermind = new Mastermind(combinationToFind);
		List<Color> combination = Collections.singletonList(Color.BLUE);
		// when quand on verifie combinaison couleur
		int wellPlacedColorCount = mastermind.play(combination);

		// then couleur bien placée
		assertEquals(1, wellPlacedColorCount);
	}

	@Test
	void shouldNotMatchCombinationForOneColor() {
		List<Color> combinationToFind = Collections.singletonList(Color.BLUE);

		// given
		Mastermind mastermind = new Mastermind(combinationToFind);
		List<Color> combination = Collections.singletonList(Color.RED);
		// when quand on verifie combinaison couleur
		int wellPlacedColorCount = mastermind.play(combination);

		// then couleur bien placée
		assertEquals(0, wellPlacedColorCount);
	}

	@Test
	void shouldMatchCombinationForTwoColors() {
		List<Color> combinationToFind = Arrays.asList(Color.BLUE, Color.RED);

		// given
		Mastermind mastermind = new Mastermind(combinationToFind);
		List<Color> combination = Arrays.asList(Color.BLUE, Color.RED);
		// when quand on verifie combinaison couleur
		int wellPlacedColorCount = mastermind.play(combination);

		// then couleur bien placée
		assertEquals(2, wellPlacedColorCount);
	}

	@Test
	void shouldMatchOnlyOneColorForTwoColors() {
		List<Color> combinationToFind = Arrays.asList(Color.RED, Color.RED);

		// given
		Mastermind mastermind = new Mastermind(combinationToFind);
		List<Color> combination = Arrays.asList(Color.BLUE, Color.RED);
		// when quand on verifie combinaison couleur
		int wellPlacedColorCount = mastermind.play(combination);

		// then couleur bien placée
		assertEquals(1, wellPlacedColorCount);
	}

}
