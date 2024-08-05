package CASE_STUDIES.TicTacToe.models;

public class Move {
    private Cell cell;

    public Move(Cell cell) {
        this.cell = cell;
    }

    public Cell getCell() {
        return cell;
    }
}
