package ru.robots.game;

public class GameState {
    private final Robot player;
    private final Robot bot;

    private BotHandler botHandler;
    private PlayerHandler playerHandler;

    private KeyboardParams keyboardParams;

    public GameState(){
        player = new Robot(100, 100, 0);
        bot = new Robot(0, 0, 0);
        keyboardParams = new KeyboardParams(false, false, false, false);
    }

    public void updateGameState(){
        if(botHandler != null) {
            botHandler.handleCommand(bot);
        }
        if(playerHandler != null) {
            playerHandler.handleCommand(player);
        }
    }

    public Robot getPlayer() {
        return player;
    }

    public Robot getBot() {
        return bot;
    }

    public KeyboardParams getKeyboardParams() {
        return keyboardParams;
    }

    public void setPlayerCommand(PlayerHandler playerHandler){
        this.playerHandler = playerHandler;
    }

    public void setBotCommand(BotHandler botHandler){
        this.botHandler = botHandler;
    }

    public void setKeyboardParams(KeyboardParams keyboardParams) {
        this.keyboardParams = keyboardParams;
    }
}
//SetCommand для бота и игрока