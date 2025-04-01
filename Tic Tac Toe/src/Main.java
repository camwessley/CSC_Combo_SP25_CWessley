public class Main {
    public static void main(String[] args) {
        char[] gameState = {'0', '1', '2', '3', '4', '5', '6', '7', '8'};

        int count = 0;
        while ( checkWinner(gameState) == 0) {
            if (count >= 8) { break; }

            board(gameState);
            move(gameState, player, choice);

            count++;

            player = player % 2 + 1;
        }

        if (checkWinner(gameState) == 1) {
            System.out.println("Player 1 wins!");

        } else if (checkWinner(gameState) == 2) {
            System.out.println("Player 2 wins!");

        } else {
            System.out.println("Tie!");
        }
    }
}