package CASE_STUDIES.TicTacToe.models;

import CASE_STUDIES.TicTacToe.strategies.botplayingstrategies.BotPlayingStrategy;
import CASE_STUDIES.TicTacToe.strategies.botplayingstrategies.BotPlayingStrategyFactory;

public class Bot extends Player{
    private BotPlayingStrategy botPlayingStrategy;
    private BotPlayingDifficulty difficulty;

    public Bot(Long id, String name, char symbol, BotPlayingDifficulty difficulty) {
        super(id, name, PlayerType.BOT, symbol);
        this.difficulty = difficulty;
        this.botPlayingStrategy = BotPlayingStrategyFactory.getStrategy(difficulty);
    }

    public Move makeMove(Board board) {
        return botPlayingStrategy.make_move(board);
    }
}
