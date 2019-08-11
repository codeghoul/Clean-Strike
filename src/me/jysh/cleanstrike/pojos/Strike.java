package me.jysh.cleanstrike.pojos;

import java.util.HashMap;
import java.util.Map;

public enum Strike {
	NORMALSTRIKE(1, "Perform Black Strike"),
	MULTISTRIKE(2, "Perform Multi Strike"),
	REDSTRIKE(3, "Perform Red Strike"),
	STRIKERSTRIKE(4, "Perform Stricker Strike"),
	DEFUNCTCOINSTRIKE(5, "Perform Defunct Coin Strike"),
	NOSTRIKE(6, "Pocket Nothing");
	
	Integer strikeChoiceNumber;
	String strikeDescription;
	private static final Map<Integer, Strike> STRIKELOOKUP = new HashMap<>();
	
	Strike(int strikeChoiceNumber, String strikeDescription) {
		this.strikeChoiceNumber = strikeChoiceNumber;
		this.strikeDescription = strikeDescription;
	}
	
	static {
		for(Strike strike : Strike.values()) {
			STRIKELOOKUP.put(strike.getStrikeChoiceNumber(), strike);
		}
	}
	
	public Integer getStrikeChoiceNumber() {
		return strikeChoiceNumber;
	}

	public String getStrikeDescription() {
		return strikeDescription;
	}

	public static Map<Integer, Strike> getStrikelookup() {
		return STRIKELOOKUP;
	}

	public void setStrikeChoiceNumber(Integer strikeChoiceNumber) {
		this.strikeChoiceNumber = strikeChoiceNumber;
	}

	public void setStrikeDescription(String strikeDescription) {
		this.strikeDescription = strikeDescription;
	}
}
