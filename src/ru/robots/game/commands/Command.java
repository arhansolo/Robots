package ru.robots.game.commands;

import ru.robots.game.gameObjects.GameObjectData;

public interface Command {
    void handleCommand(GameObjectData gameObjectData);
}
