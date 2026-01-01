package Strategy.BotStrategy;

import Models.Board;
import Models.Move;

public interface BotStrategy {
    public Move makeMove(Board b);
}
