package ru.robots.game.handlers;

import ru.robots.game.GameObjectData;
import ru.robots.game.GameState;
import ru.robots.game.commands.Command;

public abstract class Handler implements Command<GameObjectData> {
    protected final GameState gameState;

    public Handler(GameState gameState) {
        this.gameState = gameState;
    }
}
