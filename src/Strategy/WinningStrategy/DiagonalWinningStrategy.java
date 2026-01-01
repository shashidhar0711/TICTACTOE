package Strategy.WinningStrategy;

import Models.Board;
import Models.Move;
import Models.Symbol;

import java.util.HashMap;
import java.util.Map;

public class DiagonalWinningStrategy implements WinningStrategy{

    HashMap<Symbol, Integer> count1 = new HashMap<>();
    HashMap<Symbol, Integer> count2 = new HashMap<>();

    @Override
    public boolean checkWinner(Move move, Board board) {
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        Symbol s = move.getPlayer().getSymbol();

        if(row == col) {
            if(!count1.containsKey(s)) {
                count1.put(s, 0);
            }
            count1.put(s, count1.get(s) + 1);

            if(count1.get(s) == board.getSize()) {
                return true;
            }
        } else if (row+col == board.getSize() - 1) {
            if(!count2.containsKey(s)) {
                count2.put(s, 0);
            }
            count2.put(s, count2.get(s) + 1);

            if(count2.get(s) == board.getSize()) {
                return true;
            }
        }
        return false;
    }

    public void handleUndo(Move move, Board board) {
        int row = move.getCell().getCol();
        int col = move.getCell().getCol();
        Symbol s = move.getPlayer().getSymbol();

        if(row == col) {
//            Integer rowAns = count1.get(s);
//            count1.put(s, rowAns - 1);
            count1.put(s, count1.get(s) - 1);
        } else if (row+col == board.getSize() -1) {
            count2.put(s, count2.get(s)-1);
        }
    }
}
