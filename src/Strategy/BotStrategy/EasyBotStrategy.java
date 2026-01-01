package Strategy.BotStrategy;

import Models.Board;
import Models.Cell;
import Models.CellState;
import Models.Move;

import java.util.List;

public class EasyBotStrategy implements BotStrategy {
    @Override
    public Move makeMove(Board b) {
        for(List<Cell> row: b.getBoards()){
            for(Cell cell: row) {
                if(cell.getCellState().equals(CellState.EMPTY)) {
                    return new Move(cell, null);
                }
            }
        }
        return null;
    }
}
