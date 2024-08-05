package CASE_STUDIES.TicTacToe.strategies.winningstrategies;

import CASE_STUDIES.TicTacToe.models.Cell;
import CASE_STUDIES.TicTacToe.models.Player;

import java.util.HashMap;
import java.util.Map;

public class RowWinningStrategy implements WinningStrategy{
    Map<Integer, HashMap<Character,Integer>> rowMap = new HashMap<>();
    @Override
    public boolean checkWin(Cell cell, Player player, int dimension) {
        int row = cell.getRow();
        if(!rowMap.containsKey(row)) rowMap.put(row,new HashMap<>());
        int count = rowMap.get(row).getOrDefault(player.getSymbol(),0);
        count += 1;
        rowMap.get(row).put(player.getSymbol(),count);
        if(count == dimension) return true;
        return false;
    }
}
