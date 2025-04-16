import javax.swing.*;

public class CGOLDriver {
    public static void main(String[] args) {
        int rows = 50;
        int cols = 50;
        int size = 20;

        Cell[][] array = new Cell[rows][cols];

        String title = "Game of Life";
        Game game = new Game(rows, cols, size);

        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(game.getGrid());
        frame.pack();
        frame.setVisible(true);

        game.mainLoop();
    }
}