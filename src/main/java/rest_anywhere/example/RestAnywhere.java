package rest_anywhere.example;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RestAnywhere implements ModInitializer {
	public static final String MOD_ID = "rest_anywhere";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Rest Anywhere mod initialized!");
	}
}
