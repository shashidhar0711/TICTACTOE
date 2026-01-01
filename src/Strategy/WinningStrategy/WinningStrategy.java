package Strategy.WinningStrategy;

import Models.Board;
import Models.Move;

public interface WinningStrategy {

    public boolean checkWinner(Move move, Board board);
    public void handleUndo(Move move, Board board);
}
