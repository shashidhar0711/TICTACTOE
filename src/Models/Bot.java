package Models;

import Strategy.BotStrategy.BotStrategy;
import Strategy.BotStrategy.BotStrategyFactory;

public class Bot extends Player{

    private BotDifficulty botDifficulty;
    BotStrategy botStrategy;

    public Bot(int id, String name, PlayerType playerType, Symbol symbol, BotDifficulty botDifficulty) {
        super(id, name, playerType, symbol);
        this.botDifficulty = botDifficulty;
        this.botStrategy = BotStrategyFactory.getBotStrategy(botDifficulty);
    }

    public BotDifficulty getBotDifficulty() {
        return botDifficulty;
    }

    public void setBotDifficulty(BotDifficulty botDifficulty) {
        this.botDifficulty = botDifficulty;
    }

    public Move makeMove(Board b) {
        Move m = botStrategy.makeMove(b);
        m.setPlayer(this);
        return m;
    }
}
