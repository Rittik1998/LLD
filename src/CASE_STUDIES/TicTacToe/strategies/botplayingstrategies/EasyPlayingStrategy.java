package CASE_STUDIES.TicTacToe.strategies.botplayingstrategies;

import CASE_STUDIES.TicTacToe.models.Board;
import CASE_STUDIES.TicTacToe.models.CellState;
import CASE_STUDIES.TicTacToe.models.Move;
import CASE_STUDIES.TicTacToe.models.Cell;

public class EasyPlayingStrategy implements BotPlayingStrategy{
    @Override
    public Move make_move(Board board) {
        int n = board.getDimension();
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                Cell cell = board.getBoard().get(i).get(j);
                if(cell.getState()== CellState.EMPTY){
                    return new Move(new Cell(i,j));
                }
            }
        }
        return null;
    }
}
