package CASE_STUDIES.TicTacToe.models;

import java.util.Scanner;

public class Player {
    private Long id;
    private String name;
    private PlayerType type;
    private char symbol;

    public Player(Long id, String name, PlayerType type, char symbol) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.symbol = symbol;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public PlayerType getType() {
        return type;
    }

    public char getSymbol() {
        return symbol;
    }

    public Move makeMove(Board board) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the row: ");
        int row = sc.nextInt();
        System.out.println("Enter the col: ");
        int col = sc.nextInt();

        Cell cell = new Cell(row,col);
        return new Move(cell);
    }
}
