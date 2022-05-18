package ru.robots.game.commands;

public interface Command<T> {
    void handleCommand(T t);
}
