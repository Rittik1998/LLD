package CASE_STUDIES.TicTacToe.strategies.botplayingstrategies;

import CASE_STUDIES.TicTacToe.models.Board;
import CASE_STUDIES.TicTacToe.models.Move;

public interface BotPlayingStrategy {
    Move make_move(Board board);
}
