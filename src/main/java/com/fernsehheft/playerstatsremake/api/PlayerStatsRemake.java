package com.fernsehheft.playerstatsremake.api;

import com.fernsehheft.playerstatsremake.core.Main;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * The outgoing API that represents the core functionality of PlayerStatsRemake!
 *
 * <p><b>PlayerStatsRemake</b> is a fork of the original
 * <a href="https://github.com/itHotL/PlayerStats">PlayerStats</a> plugin
 * by <a href="https://github.com/Artemis-the-gr8">Artemis_the_gr8</a>.
 * All original design and concept belongs to the original author.
 *
 * <p>To work with the API, call {@link #getAPI()} to get an instance
 * of PlayerStatsRemake, then access further methods from there.
 *
 * @see StatManager
 * @see StatTextFormatter
 * @see StatNumberFormatter
 */
public interface PlayerStatsRemake {

    /**
     * Gets an instance of the PlayerStatsRemake API.
     *
     * @return the PlayerStatsRemake API
     * @throws IllegalStateException if PlayerStatsRemake is not loaded on the server
     */
    @Contract(pure = true)
    static @NotNull PlayerStatsRemake getAPI() throws IllegalStateException {
        return Main.getPlayerStatsAPI();
    }

    /**
     * Gets the version number of the PlayerStatsRemake API.
     *
     * @return the API version number
     */
    String getVersion();

    StatManager getStatManager();

    StatTextFormatter getStatTextFormatter();

    StatNumberFormatter getStatNumberFormatter();
}
