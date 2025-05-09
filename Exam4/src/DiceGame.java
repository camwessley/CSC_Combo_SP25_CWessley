import java.util.ArrayList;
import java.util.Scanner;

public class DiceGame {
    public static void main(String[] args) {
        int numSides;
        int numPlayers;

        Scanner input = new Scanner(System.in);
        System.out.print("How many sides on the die?\n> ");
        numSides = Integer.parseInt(input.nextLine());

        System.out.print("How many players?\n> ");
        numPlayers = Integer.parseInt(input.nextLine());

        Player[] players = new Player[numPlayers];

        for (int i = 0; i < numPlayers; i++) {
            System.out.printf("Player %d name:\n> ", i + 1);
            String name = input.nextLine();

            players[i] = new Player(name, numSides);
        }

        System.out.println();

        for (Player player : players) {
            player.die.roll();
            System.out.printf("Player %s rolled a %d on a %d sided die\n", player.getName(), player.die.getValue(), player.die.getNumSides());
        }

        System.out.println();

        Player[] winners = decideWinner(players);

        if (winners.length == 1) {
            System.out.printf("Player %s won the game!\n", winners[0].getName());
        } else {
            System.out.print("Players ");
            for (Player player : winners) {
                if (player == winners[winners.length - 1]) {
                    System.out.printf("and %s ", player.getName());
                } else {
                    if (winners.length == 2) {
                        System.out.printf("%s ", player.getName());
                    } else {
                        System.out.printf("%s, ", player.getName());
                    }
                }
            }

            System.out.println("tied the game!");
        }
    }

    public static Player[] decideWinner(Player[] players) {
        int highest = 0;
        ArrayList<Player> winners = new ArrayList<>();

        for (Player player : players) {
            if (player.die.getValue() > highest) {
                highest = player.die.getValue();
                winners.clear();
                winners.add(player);
            } else if (player.die.getValue() == highest) {
                winners.add(player);
            }
        }

        return winners.toArray(new Player[0]);
    }
}