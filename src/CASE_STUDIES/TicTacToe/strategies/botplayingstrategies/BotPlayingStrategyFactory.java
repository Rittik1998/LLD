package CASE_STUDIES.TicTacToe.strategies.botplayingstrategies;

import CASE_STUDIES.TicTacToe.models.BotPlayingDifficulty;

public class BotPlayingStrategyFactory {
    public static BotPlayingStrategy getStrategy(BotPlayingDifficulty difficulty){
        return switch (difficulty) {
            case HARD -> new HardPlayingStrategy();
            case MEDIUM -> new MediumPlayingStrategy();
            default -> new EasyPlayingStrategy();
        };
    }
}
