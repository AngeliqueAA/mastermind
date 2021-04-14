package com.fr.test.mastermind;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.fr.main.mastermind.Color;
import com.fr.main.mastermind.GameResult;
import com.fr.main.mastermind.Mastermind;

class MastermindTest {

	@Test
	void shouldMatchCombinationForOneColor() {
		List<Color> combinationToFind = new ArrayList<Color>(Collections.singletonList(Color.BLUE));

		// given
		Mastermind mastermind = new Mastermind(combinationToFind);
		List<Color> combination = new ArrayList<Color>(Collections.singletonList(Color.BLUE));

		// when quand on verifie combinaison couleur
		GameResult result = mastermind.playTurn(combination);

		// then couleur bien placée
		assertEquals(1, result.getWellPlacedColor());
	}

	@Test
	void shouldNotMatchCombinationForOneColor() {
		List<Color> combinationToFind = Collections.singletonList(Color.BLUE);

		// given
		Mastermind mastermind = new Mastermind(combinationToFind);
		List<Color> combination = Collections.singletonList(Color.RED);

		// when quand on verifie combinaison couleur
		GameResult result = mastermind.playTurn(combination);

		// then couleur bien placée
		assertEquals(0, result.getWellPlacedColor());
	}

	@Test
	void shouldMatchCombinationForTwoColors() {
		List<Color> combinationToFind = new ArrayList<Color>(Arrays.asList(Color.BLUE, Color.RED));

		// given
		Mastermind mastermind = new Mastermind(combinationToFind);
		List<Color> combination = new ArrayList<Color>(Arrays.asList(Color.BLUE, Color.RED));

		// when quand on verifie combinaison couleur
		GameResult result = mastermind.playTurn(combination);

		// then couleur bien placée
		assertEquals(2, result.getWellPlacedColor());
	}

	@Test
	void shouldMatchOnlyOneColorForTwoColors() {
		List<Color> combinationToFind = new ArrayList<Color>(Arrays.asList(Color.RED, Color.RED));

		// given
		Mastermind mastermind = new Mastermind(combinationToFind);
		List<Color> combination = new ArrayList<Color>(Arrays.asList(Color.BLUE, Color.RED));

		// when quand on verifie combinaison couleur
		GameResult result = mastermind.playTurn(combination);

		// then couleur bien placée
		assertEquals(1, result.getWellPlacedColor());
	}

	@Test
	void shouldNotMatchCombinationForTwoColors() {
		List<Color> combinationToFind = new ArrayList<Color>(Arrays.asList(Color.ORANGE, Color.YELLOW));

		// given
		Mastermind mastermind = new Mastermind(combinationToFind);
		List<Color> combination = new ArrayList<Color>(Arrays.asList(Color.BLUE, Color.RED));

		// when quand on verifie combinaison couleur
		GameResult result = mastermind.playTurn(combination);

		// then couleur bien placée
		assertEquals(0, result.getWellPlacedColor());
	}

	@Test
	void shouldMatchCombinationForThreeColors() {
		List<Color> combinationToFind = new ArrayList<Color>(Arrays.asList(Color.ORANGE, Color.YELLOW, Color.YELLOW));

		// given
		Mastermind mastermind = new Mastermind(combinationToFind);
		List<Color> combination = new ArrayList<Color>(Arrays.asList(Color.ORANGE, Color.YELLOW, Color.YELLOW));

		// when quand on verifie combinaison couleur
		GameResult result = mastermind.playTurn(combination);

		// then couleur bien placée
		assertEquals(3, result.getWellPlacedColor());
	}

	@Test
	void shouldMatchOnlyTwoColorForThreeColors() {
		List<Color> combinationToFind = new ArrayList<Color>(Arrays.asList(Color.ORANGE, Color.GREEN, Color.YELLOW));

		// given
		Mastermind mastermind = new Mastermind(combinationToFind);
		List<Color> combination = new ArrayList<Color>(Arrays.asList(Color.ORANGE, Color.YELLOW, Color.YELLOW));

		// when quand on verifie combinaison couleur
		GameResult result = mastermind.playTurn(combination);

		// then couleur bien placée
		assertEquals(2, result.getWellPlacedColor());
	}

	@Test
	void shouldMatchOnlyOneColorForThreeColors() {
		List<Color> combinationToFind = new ArrayList<Color>(Arrays.asList(Color.ORANGE, Color.GREEN, Color.YELLOW));

		// given
		Mastermind mastermind = new Mastermind(combinationToFind);
		List<Color> combination = new ArrayList<Color>(Arrays.asList(Color.ORANGE, Color.YELLOW, Color.GREEN));

		// when quand on verifie combinaison couleur
		GameResult result = mastermind.playTurn(combination);

		// then couleur bien placée
		assertEquals(1, result.getWellPlacedColor());
	}

	@Test
	void shouldNotMatchCombinationForThreeColors() {
		List<Color> combinationToFind = new ArrayList<Color>(Arrays.asList(Color.BLUE, Color.BLUE, Color.BLUE));

		// given
		Mastermind mastermind = new Mastermind(combinationToFind);
		List<Color> combination = new ArrayList<Color>(Arrays.asList(Color.ORANGE, Color.YELLOW, Color.GREEN));

		// when quand on verifie combinaison couleur
		GameResult result = mastermind.playTurn(combination);

		// then couleur bien placée
		assertEquals(0, result.getWellPlacedColor());
	}

	@Test
	void shouldMisplacedOneColorForTwoColor() {
		List<Color> combinationToFind = new ArrayList<Color>(Arrays.asList(Color.ORANGE, Color.GREEN));

		// given
		Mastermind mastermind = new Mastermind(combinationToFind);
		List<Color> combination = new ArrayList<Color>(Arrays.asList(Color.YELLOW, Color.ORANGE));

		// when quand on verifie combinaison couleur
		GameResult result = mastermind.playTurn(combination);

		// then couleur bien placée
		assertEquals(1, result.getMisplacedColor());
	}

	@Test
	void shouldMisplacedTwoColorForTwoColor() {
		List<Color> combinationToFind = new ArrayList<Color>(Arrays.asList(Color.ORANGE, Color.YELLOW));

		// given
		Mastermind mastermind = new Mastermind(combinationToFind);
		List<Color> combination = new ArrayList<Color>(Arrays.asList(Color.YELLOW, Color.ORANGE));

		// when quand on verifie combinaison couleur
		GameResult result = mastermind.playTurn(combination);

		// then couleur bien placée
		assertEquals(2, result.getMisplacedColor());
	}

	@Test
	void shouldMisplacedOneColorForThreeColor() {
		List<Color> combinationToFind = new ArrayList<Color>(Arrays.asList(Color.ORANGE, Color.YELLOW, Color.BLUE));

		// given
		Mastermind mastermind = new Mastermind(combinationToFind);
		List<Color> combination = new ArrayList<Color>(Arrays.asList(Color.YELLOW, Color.RED, Color.YELLOW));

		// when quand on verifie combinaison couleur
		GameResult result = mastermind.playTurn(combination);

		// then couleur bien placée
		assertEquals(1, result.getMisplacedColor());
	}

	@Test
	void shouldMatchNoColorAndMisplacedOneColorForThreeColor() {
		List<Color> combinationToFind = new ArrayList<Color>(Arrays.asList(Color.ORANGE, Color.YELLOW, Color.BLUE));

		// given
		Mastermind mastermind = new Mastermind(combinationToFind);
		List<Color> combination = new ArrayList<Color>(Arrays.asList(Color.YELLOW, Color.RED, Color.YELLOW));

		// when quand on verifie combinaison couleur
		GameResult result = mastermind.playTurn(combination);

		// then couleur bien placée
		assertEquals(0, result.getWellPlacedColor());
		assertEquals(1, result.getMisplacedColor());
	}

	@Test
	void shouldMatchOneColorAndMisplacedTwoColorForThreeColor() {
		List<Color> combinationToFind = new ArrayList<Color>(Arrays.asList(Color.YELLOW, Color.YELLOW, Color.BLUE));

		// given
		Mastermind mastermind = new Mastermind(combinationToFind);
		List<Color> combination = new ArrayList<Color>(Arrays.asList(Color.YELLOW, Color.BLUE, Color.YELLOW));

		// when quand on verifie combinaison couleur
		GameResult result = mastermind.playTurn(combination);

		// then couleur bien placée
		assertEquals(1, result.getWellPlacedColor());
		assertEquals(2, result.getMisplacedColor());
	}

	@Test
	void shouldMatchAllColorForThreeSameColor() {
		List<Color> combinationToFind = new ArrayList<Color>(Arrays.asList(Color.YELLOW, Color.YELLOW, Color.YELLOW));

		// given
		Mastermind mastermind = new Mastermind(combinationToFind);
		List<Color> combination = new ArrayList<Color>(Arrays.asList(Color.YELLOW, Color.YELLOW, Color.YELLOW));

		// when quand on verifie combinaison couleur
		GameResult result = mastermind.playTurn(combination);

		// then couleur bien placée
		assertEquals(3, result.getWellPlacedColor());
		assertEquals(0, result.getMisplacedColor());
	}

	@Test
	void shouldMatchAllColorForThreeColor() {
		List<Color> combinationToFind = new ArrayList<Color>(Arrays.asList(Color.YELLOW, Color.BLUE, Color.RED));

		// given
		Mastermind mastermind = new Mastermind(combinationToFind);
		List<Color> combination = new ArrayList<Color>(Arrays.asList(Color.YELLOW, Color.BLUE, Color.RED));

		// when quand on verifie combinaison couleur
		GameResult result = mastermind.playTurn(combination);

		// then couleur bien placée
		assertEquals(3, result.getWellPlacedColor());
		assertEquals(0, result.getMisplacedColor());
	}

	@Test
	void shouldMisplacedAllColorForThreeColor() {
		List<Color> combinationToFind = new ArrayList<Color>(Arrays.asList(Color.YELLOW, Color.BLUE, Color.RED));

		// given
		Mastermind mastermind = new Mastermind(combinationToFind);
		List<Color> combination = new ArrayList<Color>(Arrays.asList(Color.BLUE, Color.RED, Color.YELLOW));

		// when quand on verifie combinaison couleur
		GameResult result = mastermind.playTurn(combination);

		// then couleur bien placée
		assertEquals(0, result.getWellPlacedColor());
		assertEquals(3, result.getMisplacedColor());
	}

	@Test
	void shouldNotMatchandMisplacedForThreeColor() {
		List<Color> combinationToFind = new ArrayList<Color>(Arrays.asList(Color.YELLOW, Color.YELLOW, Color.YELLOW));

		// given
		Mastermind mastermind = new Mastermind(combinationToFind);
		List<Color> combination = new ArrayList<Color>(Arrays.asList(Color.ORANGE, Color.RED, Color.BLUE));

		// when quand on verifie combinaison couleur
		GameResult result = mastermind.playTurn(combination);

		// then couleur bien placée
		assertEquals(0, result.getWellPlacedColor());
		assertEquals(0, result.getMisplacedColor());
	}

	@Test
	void shouldReturn1MatchAnd2MismatchString() {
		List<Color> combinationToFind = new ArrayList<Color>(Arrays.asList(Color.ORANGE, Color.BLUE, Color.RED));

		// given
		Mastermind mastermind = new Mastermind(combinationToFind);
		List<Color> combination = new ArrayList<Color>(Arrays.asList(Color.ORANGE, Color.RED, Color.BLUE));

		// when quand on verifie combinaison couleur
		GameResult result = mastermind.playTurn(combination);

		// then couleur bien placée
		assertEquals("1 WELL_PLACED 2 MISPLACED", mastermind.displayStringResult(result));
	}

	@Test
	void shouldReturn1MatchAndZeroMismatchString() {
		List<Color> combinationToFind = new ArrayList<Color>(Arrays.asList(Color.ORANGE, Color.BLUE, Color.RED));

		// given
		Mastermind mastermind = new Mastermind(combinationToFind);
		List<Color> combination = new ArrayList<Color>(Arrays.asList(Color.ORANGE, Color.YELLOW, Color.YELLOW));

		// when quand on verifie combinaison couleur
		GameResult result = mastermind.playTurn(combination);

		// then couleur bien placée
		assertEquals("1 WELL_PLACED 0 MISPLACED", mastermind.displayStringResult(result));
	}
}
