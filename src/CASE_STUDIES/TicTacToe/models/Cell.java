package CASE_STUDIES.TicTacToe.models;

public class Cell {
    private int row;
    private int col;
    private CellState state;
    private Player player;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
        state = CellState.EMPTY;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public CellState getState() {
        return state;
    }

    public Player getPlayer() {
        return player;
    }

    public void setState(CellState state) {
        this.state = state;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
