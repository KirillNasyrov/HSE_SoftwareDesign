package kirillnasyrov.game;

import kirillnasyrov.handlers.GameHandler;
import kirillnasyrov.models.gameboard.GameBoard;
import kirillnasyrov.models.player.Computer;
import kirillnasyrov.models.player.Player;

public class Game {
    private Player playerForWhite;
    private Player playerForBlack;
    private GameMode gameMode;
    private final GameBoard gameBoard;

    public Game() {
        playerForBlack = null;
        playerForWhite = null;
        gameBoard = new GameBoard();
    }

    public Game(Game game) {
        playerForBlack = new Player(game.getPlayerForBlack());
        playerForWhite = game.getGameMode() != GameMode.PlayerVsPlayer ? new Computer(game.getPlayerForWhite()) : new Player(game.getPlayerForWhite());
        gameMode = game.getGameMode();
        gameBoard = new GameBoard(game.getGameBoard());
    }

    public void setGameMode(GameMode gameMode) {
        this.gameMode = gameMode;
    }

    public void setPlayerForWhite(Player playerForWhite) {
        this.playerForWhite = playerForWhite;
    }

    public void setPlayerForBlack(Player playerForBlack) {
        this.playerForBlack = playerForBlack;
    }

    public Player getPlayerForWhite() {
        return playerForWhite;
    }

    public Player getPlayerForBlack() {
        return playerForBlack;
    }

    public boolean isOver() {
        if (gameBoard.getNumberOfWhite() == 0 || gameBoard.getNumberOfBlack() == 0) {
            return true;
        } else if (gameBoard.getNumberOfWhite() + gameBoard.getNumberOfBlack() == 64) {
            return true;
        } else if (GameHandler.getNumberOfUsableCellsForPlayer(this, playerForBlack) == 0 &&
                GameHandler.getNumberOfUsableCellsForPlayer(this, playerForWhite) == 0) {
            return true;
        }
        return false;
    }

    public GameMode getGameMode() {
        return gameMode;
    }

    public GameBoard getGameBoard() {
        return gameBoard;
    }
}
