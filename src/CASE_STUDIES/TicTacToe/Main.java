package CASE_STUDIES.TicTacToe;

import CASE_STUDIES.TicTacToe.controllers.GameController;
import CASE_STUDIES.TicTacToe.exceptions.DuplicateSymbolException;
import CASE_STUDIES.TicTacToe.exceptions.MoreThanOneBotException;
import CASE_STUDIES.TicTacToe.exceptions.PlayersCountDimensionMismatch;
import CASE_STUDIES.TicTacToe.models.*;
import CASE_STUDIES.TicTacToe.strategies.winningstrategies.ColWinningStrategy;
import CASE_STUDIES.TicTacToe.strategies.winningstrategies.DiagonalWinningStrategy;
import CASE_STUDIES.TicTacToe.strategies.winningstrategies.RowWinningStrategy;
import CASE_STUDIES.TicTacToe.strategies.winningstrategies.WinningStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws DuplicateSymbolException, MoreThanOneBotException, PlayersCountDimensionMismatch {
        GameController gameController = new GameController();
        Scanner sc = new Scanner(System.in);
        try {
            int dimension = 3;
            List<Player> players = new ArrayList<>();
            Player player1 = new Player(1l,"Rittik", PlayerType.HUMAN,'X');
            Player player2 = new Bot(2l,"GPT",'0', BotPlayingDifficulty.EASY);
            players.add(player1);
            players.add(player2);
            List<WinningStrategy> winningStrategies = new ArrayList<>();
            winningStrategies.add(new ColWinningStrategy());
            winningStrategies.add(new RowWinningStrategy());
            winningStrategies.add(new DiagonalWinningStrategy());
            Game game = gameController.startGame(dimension,players,winningStrategies);

            while(game.getState()==GameState.IN_PROGRESS){
                gameController.printBoard(game);
                gameController.makeMove(game);
            }
        } catch (Exception e) {
            System.out.println("Something went wrong...retry");
            throw e;
        }
    }
}
