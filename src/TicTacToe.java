import javax.swing.*;
import java.awt.*;

public class TicTacToe extends JPanel {
    int boardWidth;
    int boardHeight;

    TicTacToe(int boardHeight, int boardWidth) {
        this.boardHeight = boardHeight;
        this.boardWidth = boardWidth;
        setPreferredSize(new Dimension(this.boardWidth, this.boardHeight));
        setBackground(Color.BLACK);
        setFocusable(true);
    }
}
