package CASE_STUDIES.TicTacToe.strategies.winningstrategies;

import CASE_STUDIES.TicTacToe.models.Cell;
import CASE_STUDIES.TicTacToe.models.Player;

public interface WinningStrategy {
    boolean checkWin(Cell cell, Player player, int dimension);
}
