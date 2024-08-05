package CASE_STUDIES.TicTacToe.strategies.winningstrategies;
import CASE_STUDIES.TicTacToe.models.Cell;

import java.util.Map;
import java.util.HashMap;

import CASE_STUDIES.TicTacToe.models.Player;
public class ColWinningStrategy implements WinningStrategy{
    Map<Integer, HashMap<Character,Integer>> colMap = new HashMap<>();
    @Override
    public boolean checkWin(Cell cell, Player player, int dimension) {
        int col = cell.getCol();
        if(!colMap.containsKey(col)) colMap.put(col,new HashMap<>());
        int count = colMap.get(col).getOrDefault(player.getSymbol(),0);
        count += 1;
        colMap.get(cell.getCol()).put(player.getSymbol(),count);
        if(count == dimension) return true;
        return false;
    }
}