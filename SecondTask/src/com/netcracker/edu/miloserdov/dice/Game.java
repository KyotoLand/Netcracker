package com.netcracker.edu.miloserdov.dice;

import java.util.Map;

/**
 * Represents the interface of games.
 * Contains parameters set method and start playing method.
 */

public interface Game {

    /**
     * Sets parameters of the game from input Map.
     * @param parameters Map<String paramName, int paramValue>
     */

    void setGameParameters(Map<String, Integer> parameters);

    /**
     * Start playing.
     */

    void start();

}
