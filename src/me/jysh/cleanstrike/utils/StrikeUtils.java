package me.jysh.cleanstrike.utils;

import me.jysh.cleanstrike.pojos.DefunctCoinStrike;
import me.jysh.cleanstrike.pojos.strikes.MultiStrike;
import me.jysh.cleanstrike.pojos.strikes.NoStrike;
import me.jysh.cleanstrike.pojos.strikes.NormalStrike;
import me.jysh.cleanstrike.pojos.strikes.RedStrike;
import me.jysh.cleanstrike.pojos.strikes.EnumStrike;
import me.jysh.cleanstrike.pojos.strikes.StrikerStrike;
import me.jysh.cleanstrike.pojos.strikes.iStrike;

import java.util.function.Supplier;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class StrikeUtils {
	private static final Map<EnumStrike, Supplier<iStrike>> STRIKESUPPLIER;

	static {
		final Map<EnumStrike, Supplier<iStrike>> strikes = new HashMap<>();
		strikes.put(EnumStrike.NORMALSTRIKE, NormalStrike::new);
		strikes.put(EnumStrike.MULTISTRIKE, MultiStrike::new);
		strikes.put(EnumStrike.REDSTRIKE, RedStrike::new);
		strikes.put(EnumStrike.STRIKERSTRIKE, StrikerStrike::new);
		strikes.put(EnumStrike.DEFUNCTCOINSTRIKE, DefunctCoinStrike::new);
		strikes.put(EnumStrike.NOSTRIKE, NoStrike::new);
		
		STRIKESUPPLIER = Collections.unmodifiableMap(strikes);	
	}
	
	public static Map<EnumStrike, Supplier<iStrike>> getStrikesupplier() {
		return STRIKESUPPLIER;
	}
}
