package ru.robots.game;

public class MouseParams {
    public MouseParams(boolean isClicked){
        this.isClicked = isClicked;
    }

    public boolean isClicked() {
        return isClicked;
    }

    public void setClicked(boolean clicked) {
        isClicked = clicked;
    }

    private boolean isClicked;
}
