package Strategy.BotStrategy;

import Models.BotDifficulty;

public class BotStrategyFactory {
    public static BotStrategy getBotStrategy(BotDifficulty botDifficulty) {
        if(botDifficulty.equals(BotDifficulty.EASY)) {
            return new EasyBotStrategy();
        }
        return null;
    }
}
