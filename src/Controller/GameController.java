package Controller;

import Models.Game;
import Models.GameState;
import Models.Player;
import Strategy.WinningStrategy.WinningStrategy;

import java.util.List;

public class GameController {

//    public Game game;

    public Game StartGame(int dimension, List<Player> p, List<WinningStrategy> w) throws Exception {
        Game game = Game.getBuilder()
                .setDimension(dimension)
                .setPlayers(p)
                .setWinningStrategies(w)
                .build();
        return game;
    }

    public void displayBoard(Game game) {
        game.getBoard().printBoard();
    }

    public void makeMove(Game game) {
        game.makeMove();
    }

    public GameState checkState(Game game) {
        return game.getGameState();
    }

    public Player winner(Game game) {
        return game.getWinner();
    }

    public void undo(Game game) {
        game.undo();
    }
}
