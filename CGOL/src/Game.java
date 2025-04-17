public class Game {
    Grid grid;

    public Game(int r, int c, int s) {
        grid = new Grid(r, c, s);
        grid.turnOn(2,2);
        grid.turnOn(2,3);
        grid.turnOn(3,2);
        grid.turnOn(3,3);

        grid.turnOn(8,8);
        grid.turnOn(8,9);
        grid.turnOn(8,10);
    }

    public Grid getGrid() {return grid;}

    public void mainLoop() {
        while (true) {
            this.update();
            grid.repaint();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {}
        }
    }

    private void update() {
        int[][] counts = countNeighbors();
        updateGrid(counts);
    }

    private void updateGrid(int[][] counts) {
        int rows = grid.numRows();
        int cols = grid.numCols();

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                Cell cell = grid.getCell(r, c);
                updateCell(cell, counts[r][c]);
            }
        }
    }

    private void updateCell(Cell cell, int count) {
        if (cell.isOn()) {
            if (count < 2 || count > 3) {
                cell.turnOff();
            }
        } else if (count == 3) {
            cell.turnOn();
        }
    }

    private int[][] countNeighbors() {
        int rows = grid.numRows();
        int cols = grid.numCols();

        int[][] counts = new int[rows][cols];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                counts[r][c] = countAlive(r, c);
            }
        }

        return counts;
    }

    private int countAlive(int r, int c) {
        int count = 0;
        count += grid.test(r - 1, c - 1);
        count += grid.test(r - 1, c);
        count += grid.test(r - 1, c + 1);
        count += grid.test(r, c - 1);
        count += grid.test(r, c + 1);
        count += grid.test(r + 1, c - 1);
        count += grid.test(r + 1, c);
        count += grid.test(r + 1, c + 1);

        return count;
    }
}