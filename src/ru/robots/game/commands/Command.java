package ru.robots.game.commands;

import ru.robots.game.GameObjectData;

public interface Command {
    void handleCommand(GameObjectData gameObjectData);
}
