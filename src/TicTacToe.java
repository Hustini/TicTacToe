import javax.swing.*;
import java.awt.*;

public class TicTacToe extends JPanel {
    private class Tile {
        int x;
        int y;
        String symbol;

        Tile(int x, int y, String symbol) {
            this.x = x;
            this.y = y;
            this.symbol = symbol;
        }

        public String getSymbol()
        {
            return symbol;
        }
    }

    int boardWidth;
    int boardHeight;
    int tileSize = 200;

    Tile[][] board = new Tile[3][3];
    Tile tile = new Tile(0, 0, "");

    TicTacToe(int boardHeight, int boardWidth) {
        this.boardHeight = boardHeight;
        this.boardWidth = boardWidth;
        setPreferredSize(new Dimension(this.boardWidth, this.boardHeight));
        setBackground(Color.BLACK);
        setFocusable(true);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Tile newTile = new Tile(0, 0, "-");
                board[i][j] = newTile;
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j].getSymbol() + " ");
            }
            System.out.println();
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                g.setColor(Color.GRAY);
                g.fill3DRect(tile.x * tileSize + (j * 200), tile.y * tileSize + (i * 200), tileSize, tileSize, true);
            }
        }
    }
}
