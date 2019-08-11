package me.jysh.cleanstrike.utils;

import me.jysh.cleanstrike.pojos.DefunctCoinStrike;
import me.jysh.cleanstrike.pojos.MultiStrike;
import me.jysh.cleanstrike.pojos.NoStrike;
import me.jysh.cleanstrike.pojos.NormalStrike;
import me.jysh.cleanstrike.pojos.RedStrike;
import me.jysh.cleanstrike.pojos.Strike;
import me.jysh.cleanstrike.pojos.StrikerStrike;
import me.jysh.cleanstrike.pojos.iStrike;

import java.util.function.Supplier;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class StrikeUtils {
	private static final Map<Strike, Supplier<iStrike>> STRIKESUPPLIER;
	
	static {
		final Map<Strike, Supplier<iStrike>> strikes = new HashMap<>();
		strikes.put(Strike.NORMALSTRIKE, NormalStrike::new);
		strikes.put(Strike.MULTISTRIKE, MultiStrike::new);
		strikes.put(Strike.REDSTRIKE, RedStrike::new);
		strikes.put(Strike.STRIKERSTRIKE, StrikerStrike::new);
		strikes.put(Strike.DEFUNCTCOINSTRIKE, DefunctCoinStrike::new);
		strikes.put(Strike.NOSTRIKE, NoStrike::new);
		
		STRIKESUPPLIER = Collections.unmodifiableMap(strikes);	
	}
	
	public iStrike strikeSorter(Strike strike) {
		Supplier<iStrike> strikeType = STRIKESUPPLIER.get(strike);
		
		if(strikeType == null) {
			throw new IllegalArgumentException("Invalid Sorter Type: " + strike.getStrikeDescription());
		}
		
		return strikeType.get();
	}
}
