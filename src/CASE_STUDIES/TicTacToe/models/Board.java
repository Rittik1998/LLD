package CASE_STUDIES.TicTacToe.models;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private int dimension;
    private List<List<Cell>> board;

    public Board(int dimension) {
        this.dimension = dimension;
        board = new ArrayList<>();

        for(int i=0; i<dimension; i++){
            board.add(new ArrayList<>());

            for(int j=0; j<dimension; j++){
                board.get(i).add(new Cell(i,j));
            }
        }
    }

    public void printBoard() {
        for(int i=0; i<dimension; i++){
            for(int j=0; j<dimension; j++){
                Cell cell = board.get(i).get(j);
                if(cell.getState()==CellState.EMPTY){
                    System.out.print("| - |");
                }
                else{
                    System.out.print("| " + cell.getPlayer().getSymbol() + " |");
                }
            }
            System.out.println();
        }
    }

    public int getDimension() {
        return dimension;
    }

    public List<List<Cell>> getBoard() {
        return board;
    }
}
