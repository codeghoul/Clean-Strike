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
		strikeSupplier.put(StrikeInformation.NORMAL_STRIKE, NormalStrike::getInstance);
		strikeSupplier.put(StrikeInformation.MULTI_STRIKE, MultiStrike::getInstance);
		strikeSupplier.put(StrikeInformation.RED_STRIKE, RedStrike::getInstance);
		strikeSupplier.put(StrikeInformation.STRIKER_STRIKE, StrikerStrike::getInstance);
		strikeSupplier.put(StrikeInformation.DEFUNCT_BLACK_COIN_STRIKE, DefunctBlackCoinStrike::getInstance);
		strikeSupplier.put(StrikeInformation.DEFUNCT_RED_COIN_STRIKE, DefunctRedCoinStrike::getInstance);
		strikeSupplier.put(StrikeInformation.NO_STRIKE, NoStrike::getInstance);

		STRIKESUPPLIER = Collections.unmodifiableMap(strikeSupplier);
		
		LOGGER.debug("Strike Supplier Initialized");
	}

	public static Map<StrikeInformation, Supplier<iStrike>> getStrikeSupplier() {
		LOGGER.debug("Strike Supplier Sent");
		return STRIKESUPPLIER;
	}
}
