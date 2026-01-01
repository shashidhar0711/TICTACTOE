package Strategy.WinningStrategy;

import Models.Board;
import Models.Move;
import Models.Symbol;

import java.util.HashMap;
import java.util.Map;

public class RowWinningStrategy implements WinningStrategy{

    Map<Integer, Map<Symbol, Integer>> counts = new HashMap<>();
    @Override
    public boolean checkWinner(Move move, Board board) {
        int row = move.getCell().getRow();
        Symbol s = move.getPlayer().getSymbol();

        if(!counts.containsKey(row)) {
            counts.put(row, new HashMap<>());
        }

        Map<Symbol, Integer> hs = counts.get(row);
        if(!hs.containsKey(s)) {
            hs.put(s, 0);
        }

        hs.put(s, hs.get(s) + 1);

        return hs.get(s) == board.getSize();
    }

    public void handleUndo(Move move, Board board) {
        int row = move.getCell().getRow();
        Symbol s = move.getPlayer().getSymbol();
        Map<Symbol, Integer> rowMap = counts.get(row);
        rowMap.put(s, rowMap.get(s) - 1);
    }
}
