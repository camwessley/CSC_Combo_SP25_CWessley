public class Game {
    Grid grid;

    public Game(int r, int c, int s) {
        grid = new Grid(r, c, s);
        grid.turnOn(2, 1);
        grid.turnOn(2, 2);
        grid.turnOn(2, 3);
        grid.turnOn(1, 7);
        grid.turnOn(2, 7);
        grid.turnOn(3, 7);
    }

    public Grid getGrid() {
        return grid;
    }
}