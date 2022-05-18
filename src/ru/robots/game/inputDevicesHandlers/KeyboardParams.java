package ru.robots.game.inputDevicesHandlers;

public class KeyboardParams {
    public KeyboardParams(boolean isLeft, boolean isRight, boolean isUp, boolean isDown, boolean alreadyDashed) {
        this.isLeft = isLeft;
        this.isRight = isRight;
        this.isUp = isUp;
        this.isDown = isDown;
        this.alreadyDashed = alreadyDashed;
    }

    private boolean isLeft;
    private boolean isRight;
    private boolean isUp;
    private boolean isDown;
    private boolean dash;
    private boolean alreadyDashed;

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

    public void setDash (boolean dash) {
        if (!dash) alreadyDashed = false;
        this.dash = dash;
    }

    public void setAlreadyDashed (boolean alreadyDashed){
        this.alreadyDashed = alreadyDashed;
    }

    public boolean isAlreadyDashed() {
        return alreadyDashed;
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

    public boolean isDash() {
        return dash;
    }

    public boolean getAlreadyDashed() {
        return alreadyDashed;
    }

    public boolean dashIsOk() {
        return dash && !alreadyDashed;
    }
}
