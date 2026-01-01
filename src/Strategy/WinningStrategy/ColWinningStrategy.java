package Strategy.WinningStrategy;

import Models.Board;
import Models.Move;
import Models.Symbol;

import java.util.HashMap;
import java.util.Map;

public class ColWinningStrategy implements WinningStrategy{

    Map<Integer, Map<Symbol, Integer>> counts = new HashMap<>();

    @Override
    public boolean checkWinner(Move move, Board board) {
        int col = move.getCell().getCol();
        Symbol s = move.getPlayer().getSymbol();

        if(!counts.containsKey(col)) {
            counts.put(col, new HashMap<>());
        }

        Map<Symbol, Integer> hs = counts.get(col);
        if(!hs.containsKey(s)) {
            hs.put(s, 0);
        }

        hs.put(s, hs.get(s) + 1);

        return hs.get(s) == board.getSize();
    }

    public void handleUndo(Move move, Board board) {
        int col = move.getCell().getCol();
        Symbol s = move.getPlayer().getSymbol();
        Map<Symbol, Integer> colMap = counts.get(col);
        colMap.put(s, colMap.get(s) - 1);
    }
}
