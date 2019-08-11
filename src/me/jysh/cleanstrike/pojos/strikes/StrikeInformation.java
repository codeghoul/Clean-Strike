package me.jysh.cleanstrike.pojos.strikes;

import java.util.HashMap;
import java.util.Map;

public enum StrikeInformation {
	NORMALSTRIKE("1", "pocket Black Coin."),
	MULTISTRIKE("2", "pocket Multiple Black Coins."),
	REDSTRIKE("3", "pocket Red Coin."),
	STRIKERSTRIKE("4", "pocket Striker."),
	DEFUNCTBLACKCOINSTRIKE("5", "defunct Black Coin."),
	DEFUNCTREDCOINSTRIKE("6", "defunct Red Coin."),
	NOSTRIKE("7", "pocket nothing.");
	
	String strikeChoice;
	String strikeDescription;
	private static final Map<String, StrikeInformation> STRIKELOOKUP = new HashMap<>();
	
	StrikeInformation(String strikeChoice, String strikeDescription) {
		this.strikeChoice = strikeChoice;
		this.strikeDescription = strikeDescription;
	}
	
	static {
		for(StrikeInformation strike : StrikeInformation.values()) {
			STRIKELOOKUP.put(strike.getStrikeChoice(), strike);
		}
	}
	
	public String getStrikeChoice() {
		return strikeChoice;
	}

	public String getStrikeDescription() {
		return strikeDescription;
	}

	public static StrikeInformation getStrikelookup(String strikeChoice) {
		return STRIKELOOKUP.get(strikeChoice);
	}

	public void setStrikeChoiceNumber(String strikeChoice) {
		this.strikeChoice = strikeChoice;
	}

	public void setStrikeDescription(String strikeDescription) {
		this.strikeDescription = strikeDescription;
	}
}
