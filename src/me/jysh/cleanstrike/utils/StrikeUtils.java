package me.jysh.cleanstrike.utils;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import me.jysh.cleanstrike.pojos.strikes.*;

public class StrikeUtils {
	private static final Map<StrikeInformation, Supplier<iStrike>> STRIKESUPPLIER;
	private static final Logger LOGGER = LogManager.getLogger(StrikeUtils.class.getClass());

	static {
		final Map<StrikeInformation, Supplier<iStrike>> strikeSupplier = new HashMap<>();
		strikeSupplier.put(StrikeInformation.NORMALSTRIKE, NormalStrike::new);
		strikeSupplier.put(StrikeInformation.MULTISTRIKE, MultiStrike::new);
		strikeSupplier.put(StrikeInformation.REDSTRIKE, RedStrike::new);
		strikeSupplier.put(StrikeInformation.STRIKERSTRIKE, StrikerStrike::new);
		strikeSupplier.put(StrikeInformation.DEFUNCTBLACKCOINSTRIKE, DefunctBlackCoinStrike::new);
		strikeSupplier.put(StrikeInformation.DEFUNCTREDCOINSTRIKE, DefunctRedCoinStrike::new);
		strikeSupplier.put(StrikeInformation.NOSTRIKE, NoStrike::new);

		STRIKESUPPLIER = Collections.unmodifiableMap(strikeSupplier);
		
		LOGGER.debug("Strike Supplier Initialized");
	}

	public static Map<StrikeInformation, Supplier<iStrike>> getStrikeSupplier() {
		LOGGER.debug("Strike Supplier Sent");
		return STRIKESUPPLIER;
	}
}
