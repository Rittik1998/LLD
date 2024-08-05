package CASE_STUDIES.TicTacToe.models;

import CASE_STUDIES.TicTacToe.exceptions.DuplicateSymbolException;
import CASE_STUDIES.TicTacToe.exceptions.MoreThanOneBotException;
import CASE_STUDIES.TicTacToe.exceptions.PlayersCountDimensionMismatch;
import CASE_STUDIES.TicTacToe.strategies.winningstrategies.WinningStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {

    private Board board;
    private List<Player> players;
    private int nextPlayerIndex;
    private Player winner;
    private List<WinningStrategy> winningStrategies;
    private GameState state;
    private List<Move> moves;

    private Game(int dimension, List<Player> players, List<WinningStrategy> winningStrategies) {
        this.board = new Board(dimension);
        this.players = players;
        nextPlayerIndex = 0;
        this.winningStrategies = winningStrategies;
        state = GameState.IN_PROGRESS;
        moves = new ArrayList<>();
    }

    public static Builder getBuilder(){
        return new Builder();
    }

    public void printBoard() {
        board.printBoard();
    }

    public void makeMove() {
        System.out.println("The nxt player index is: " + nextPlayerIndex);
        Player currentPlayer = players.get(nextPlayerIndex);
        System.out.println("It's " + currentPlayer.getName() + "'s turn." +
                "Please make a move");
        Move move = currentPlayer.makeMove(board);
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        System.out.println(currentPlayer.getName() + " has made a move at " + row + "th row and " + col + "th column");

        if(!validateMove(row,col)){
            System.out.println("Invalid move...try again");
            return;
        }

        Cell cell = board.getBoard().get(row).get(col);
        cell.setState(CellState.FILLED);
        cell.setPlayer(currentPlayer);
        moves.add(new Move(cell));

        if(checkWin(cell,currentPlayer)){
            System.out.println(currentPlayer.getName() + " has won the game");
            state = GameState.WIN;
            return;
        }
        int n = board.getDimension();
        if(moves.size() == n*n){
            System.out.println("Game is drawn");
            state = GameState.DRAW;
        }

        nextPlayerIndex += 1;
        nextPlayerIndex %= (n-1);
    }

    private boolean checkWin(Cell cell,Player currentPlayer) {
        int dimension = board.getDimension();
        for(WinningStrategy winningStrategy: winningStrategies){
            if(winningStrategy.checkWin(cell, currentPlayer, dimension)){
                return true;
            }
        }
        return false;
    }

    private boolean validateMove(int row, int col) {
        int n = board.getDimension();
        System.out.println("The dimension is :" + n);
        System.out.println("The entered row is: " + row);
        System.out.println("The entered row is: " + row);
        if(row<0 || row>= n || col<0 || col>=n){
            return false;
        }
        if(board.getBoard().get(row).get(col).getState()==CellState.FILLED){
            return false;
        }
        return true;
    }

    public static class Builder{
        private int dimension;
        private List<Player> players;
        private List<WinningStrategy> winningStrategies;

        private Builder() {
            this.dimension = 0;
            this.players = new ArrayList<>();
            this.winningStrategies = new ArrayList<>();
        }

        public Builder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }

        public Builder setPlayer(List<Player> players) {
            this.players = players;
            return this;
        }

        public Builder addPlayer(Player player) {
            this.players.add(player);
            return this;
        }

        public Builder setWinningStrategies(List<WinningStrategy> winningStrategies) {
            this.winningStrategies = winningStrategies;
            return this;
        }

        public Builder addWinningStrategies(WinningStrategy winningStrategies) {
            this.winningStrategies.add(winningStrategies);
            return this;
        }

        private void validateUniqueSymbolsForPlayers() throws DuplicateSymbolException {
            Map<Character,Integer> symbolMap = new HashMap<>();
            for(Player player: players){
                char symbol = player.getSymbol();
                if(symbolMap.containsKey(symbol)){
                    throw new DuplicateSymbolException();
                }
                symbolMap.put(symbol,1);
            }
        }

        private void validateNumberOfBots() throws MoreThanOneBotException {
            int botCount = 0;
            for(Player player: players){
                if(player.getType() == PlayerType.BOT) botCount++;
                if(botCount>1){
                    throw new MoreThanOneBotException();
                }
            }
        }

        private void validateDimensionsAndPlayerCount() throws PlayersCountDimensionMismatch {
            if(dimension!=players.size()+1){
                throw new PlayersCountDimensionMismatch();
            }
        }

        private void validate() throws DuplicateSymbolException, MoreThanOneBotException, PlayersCountDimensionMismatch {
            validateUniqueSymbolsForPlayers();
            validateNumberOfBots();
            validateDimensionsAndPlayerCount();
        }

        public Game build() throws DuplicateSymbolException, MoreThanOneBotException, PlayersCountDimensionMismatch {
            validate();
            return new Game(dimension, players, winningStrategies);
        }

    }

    public Board getBoard() {
        return board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public int getNextPlayerIndex() {
        return nextPlayerIndex;
    }

    public Player getWinner() {
        return winner;
    }

    public List<WinningStrategy> getWinningStrategies() {
        return winningStrategies;
    }

    public GameState getState() {
        return state;
    }

    public List<Move> getMoves() {
        return moves;
    }
}
