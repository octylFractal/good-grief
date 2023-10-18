package net.octyl.mc.goodgrief;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Mod initializer for Good Grief!.
 */
public class GoodGrief implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("goodgrief");

    @Override
    public void onInitialize() {
        LOGGER.info("[Good Grief!] Finally, no more griefing...");
    }
}
