import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Frame size
        int boardWidth = 600;
        int boardHeight = 600;

        // Frame
        JFrame frame = new JFrame("TicTacToe");
        frame.setVisible(true);
        frame.setSize(boardWidth, boardHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        TicTacToe ticTacToe = new TicTacToe(boardHeight, boardWidth);
        frame.add(ticTacToe);
        frame.pack();
        ticTacToe.requestFocus();
    }
}