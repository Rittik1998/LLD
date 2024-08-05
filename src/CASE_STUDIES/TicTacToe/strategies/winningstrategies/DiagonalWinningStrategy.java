package CASE_STUDIES.TicTacToe.strategies.winningstrategies;

import CASE_STUDIES.TicTacToe.models.Cell;
import CASE_STUDIES.TicTacToe.models.Player;

import java.util.HashMap;
import java.util.Map;

public class DiagonalWinningStrategy implements WinningStrategy{
    HashMap<Character,Integer> leftDiagonalMap = new HashMap<>();
    HashMap<Character,Integer> rightDiagonalMap = new HashMap<>();
    @Override
    public boolean checkWin(Cell cell, Player player, int dimension) {
        int row = cell.getRow();
        int col = cell.getCol();

        //left diagonal check
        if(row==col){
            int count = leftDiagonalMap.getOrDefault(player.getSymbol(),0);
            count += 1;
            leftDiagonalMap.put(player.getSymbol(),count);
            if(count==dimension) return true;
        }

        //right diagonal check
        if ((row + col) == dimension-1) {
            int count = rightDiagonalMap.getOrDefault(player.getSymbol(),0);
            count += 1;
            rightDiagonalMap.put(player.getSymbol(),count);
            if(count==dimension) return true;
        }
        return false;
    }
}
