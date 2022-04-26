package ru.robots.game;

public class KeyboardParams {
    public KeyboardParams(boolean isLeft, boolean isRight, boolean isUp, boolean isDown) {
        this.isLeft = isLeft;
        this.isRight = isRight;
        this.isUp = isUp;
        this.isDown = isDown;
    }

    private boolean isLeft;
    private boolean isRight;
    private boolean isUp;
    private boolean isDown;

    public void setLeft(boolean left) {
        isLeft = left;
    }

    public void setRight(boolean right) {
        isRight = right;
    }

    public void setUp(boolean up) {
        isUp = up;
    }

    public void setDown(boolean down) {
        isDown = down;
    }

    public boolean isLeft() {
        return isLeft;
    }

    public boolean isRight() {
        return isRight;
    }

    public boolean isUp() {
        return isUp;
    }

    public boolean isDown() {
        return isDown;
    }
}
