import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TicTacToe extends JPanel implements MouseListener {
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

        public void setSymbol(String symbol) {
            this.symbol = symbol;
        }
    }

    int boardWidth;
    int boardHeight;
    int tileSize = 200;

    Tile[][] board = new Tile[3][3];
    Tile tile = new Tile(0, 0, "");

    String currentPlayer = "X";

    TicTacToe(int boardHeight, int boardWidth) {
        this.boardHeight = boardHeight;
        this.boardWidth = boardWidth;
        setPreferredSize(new Dimension(this.boardWidth, this.boardHeight));
        setBackground(Color.BLACK);
        setFocusable(true);
        addMouseListener(this);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Tile newTile = new Tile(0, 0, "_");
                board[i][j] = newTile;
            }
        }

        printBoard();
    }

    public void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("| " + board[i][j].getSymbol() + " |");
            }
            System.out.println();
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
        checkWinner(g);
    }

    public void draw(Graphics g) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                g.setColor(Color.GRAY);
                g.fill3DRect(tile.x * tileSize + (j * 200), tile.y * tileSize + (i * 200), tileSize, tileSize, true);
                g.setColor(Color.BLACK);
                g.drawString(board[i][j].getSymbol(), j * tileSize + tileSize / 2, i * tileSize + tileSize / 2);
            }
        }
    }

    public Tile[] checkWinner(Graphics g) {
        for (int i = 0; i < 3; i++) {
            // Check cols
            if (board[i][0].getSymbol().equals("X") && board[i][1].getSymbol().equals("X") && board[i][2].getSymbol().equals("X")) {
                System.out.println("Player X Wins");
                return new Tile[]{board[i][0], board[i][1], board[i][2]};
            } else if (board[i][0].getSymbol().equals("O") && board[i][1].getSymbol().equals("O") && board[i][2].getSymbol().equals("O")) {
                System.out.println("Player O Wins");
                return new Tile[]{board[i][0], board[i][1], board[i][2]};
            }

            // check rows
            if (board[0][i].getSymbol().equals("X") && board[1][i].getSymbol().equals("X") && board[2][i].getSymbol().equals("X")) {
                System.out.println("Player X Wins");
                return new Tile[]{board[0][i], board[1][i], board[2][i]};
            } else if (board[0][i].getSymbol().equals("O") && board[1][i].getSymbol().equals("O") && board[2][i].getSymbol().equals("O")) {
                System.out.println("Player O Wins");
                return new Tile[]{board[0][i], board[1][i], board[2][i]};
            }
        }

        // check diagonal
        if (board[0][0].getSymbol().equals("X") && board[1][1].getSymbol().equals("X") && board[2][2].getSymbol().equals("X")) {
            System.out.println("Player X Wins");
            return new Tile[]{board[0][0], board[1][1], board[2][2]};
        } else if (board[0][0].getSymbol().equals("O") && board[1][1].getSymbol().equals("O") && board[2][2].getSymbol().equals("O")) {
            System.out.println("Player O Wins");
            return new Tile[]{board[0][0], board[1][1], board[2][2]};
        }

        if (board[0][2].getSymbol().equals("X") && board[1][1].getSymbol().equals("X") && board[2][0].getSymbol().equals("X")) {
            System.out.println("Player X Wins");
            return new Tile[]{board[0][2], board[1][1], board[2][0]};

        } else if (board[0][2].getSymbol().equals("O") && board[1][1].getSymbol().equals("O") && board[2][0].getSymbol().equals("O")) {
            System.out.println("Player O Wins");
            return new Tile[]{board[0][2], board[1][1], board[2][0]};

        }
        return null;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int mouseX = e.getX() / tileSize;
        int mouseY = e.getY() / tileSize;
        if (board[mouseY][mouseX].getSymbol().equals("_")) {
            if (currentPlayer.equals("X")) {
                System.out.println(mouseX + " " + mouseY + " " + currentPlayer);
                board[mouseY][mouseX].setSymbol(currentPlayer);
                currentPlayer = "O";
            } else if (currentPlayer.equals("O")) {
                System.out.println(mouseX + " " + mouseY + " " + currentPlayer);
                board[mouseY][mouseX].setSymbol(currentPlayer);
                currentPlayer = "X";
            }
            printBoard();
        }
        repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}
