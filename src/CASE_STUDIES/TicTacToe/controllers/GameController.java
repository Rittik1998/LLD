package CASE_STUDIES.TicTacToe.controllers;

import CASE_STUDIES.TicTacToe.exceptions.DuplicateSymbolException;
import CASE_STUDIES.TicTacToe.exceptions.MoreThanOneBotException;
import CASE_STUDIES.TicTacToe.exceptions.PlayersCountDimensionMismatch;
import CASE_STUDIES.TicTacToe.models.Game;
import CASE_STUDIES.TicTacToe.models.Player;
import CASE_STUDIES.TicTacToe.strategies.winningstrategies.WinningStrategy;

import java.util.List;

public class GameController {

    public Game startGame(int dimension, List<Player> players, List<WinningStrategy> winningStrategies)
            throws DuplicateSymbolException, MoreThanOneBotException, PlayersCountDimensionMismatch {
        System.out.println("Game has started");
        return Game.getBuilder().setDimension(dimension).setPlayer(players).setWinningStrategies(winningStrategies).build();
    }

    public void printBoard(Game game) {
        game.printBoard();
    }

    public void makeMove(Game game) {
        game.makeMove();
    }
}
