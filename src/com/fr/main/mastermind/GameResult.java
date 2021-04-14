package com.fr.main.mastermind;

public class GameResult {

	private int wellPlacedColor;
	private int misplacedColor;

	public GameResult(int wellPlacedColor, int misplacedColor) {
		super();
		this.wellPlacedColor = wellPlacedColor;
		this.misplacedColor = misplacedColor;
	}

	public int getWellPlacedColor() {
		return wellPlacedColor;
	}

	public int getMisplacedColor() {
		return misplacedColor;
	}

}
