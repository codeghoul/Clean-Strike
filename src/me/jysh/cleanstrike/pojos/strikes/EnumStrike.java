package me.jysh.cleanstrike.pojos.strikes;

import java.util.HashMap;
import java.util.Map;

public enum EnumStrike {
	NORMALSTRIKE("1", "Perform Black EnumStrike"),
	MULTISTRIKE("2", "Perform Multi EnumStrike"),
	REDSTRIKE("3", "Perform Red EnumStrike"),
	STRIKERSTRIKE("4", "Perform Stricker EnumStrike"),
	DEFUNCTCOINSTRIKE("5", "Perform Defunct Coin EnumStrike"),
	NOSTRIKE("6", "Pocket Nothing");
	
	String strikeChoice;
	String strikeDescription;
	private static final Map<String, EnumStrike> STRIKELOOKUP = new HashMap<>();
	
	EnumStrike(String strikeChoice, String strikeDescription) {
		this.strikeChoice = strikeChoice;
		this.strikeDescription = strikeDescription;
	}
	
	static {
		for(EnumStrike strike : EnumStrike.values()) {
			STRIKELOOKUP.put(strike.getStrikeChoice(), strike);
		}
	}
	
	public String getStrikeChoice() {
		return strikeChoice;
	}

	public String getStrikeDescription() {
		return strikeDescription;
	}

	public static EnumStrike getStrikelookup(String strikeChoice) {
		return STRIKELOOKUP.get(strikeChoice);
	}

	public void setStrikeChoiceNumber(String strikeChoice) {
		this.strikeChoice = strikeChoice;
	}

	public void setStrikeDescription(String strikeDescription) {
		this.strikeDescription = strikeDescription;
	}
}
