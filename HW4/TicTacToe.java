//In order to help learn course concepts,
//I worked on the homework with Jinghong Peng,
//discussed homework topics and issues with Jinghong Peng,
//and/or consulted related
//material that can be found at
//no site other than course material.
import java.util.Scanner;
import java.util.Random;

public class TicTacToe {


    // Place your methods here
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numPlayers = getNumberPlayers(sc);
        if (numPlayers == 1) {
            onePlayerGame(sc);
        } else {
            twoPlayerGame(sc);
        }
    }

    public static void onePlayerGame(Scanner sc) {
        Board tic = new Board();
        for (int i = 0; i < 9; i++) {
            if (i == 0) {
                System.out.println(tic);
            }
        //the real player's turn
            if (i % 2 == 0) {
                boolean goodLocation = false;
                // a while loop for player to enter the right location
                while (!goodLocation) {
                    Location l = getInput("1", sc);
                    if (tic.placeLetter(l, 'X')) {
                        goodLocation = true;
                    }
                }
                System.out.println(tic);
        //the computer player's turn
            } else {
                Random rand = new Random();
                System.out.println("The Computer is making a move...");
                boolean autoGood = false;
                while (!autoGood) {
                    Location auto = new Location(rand.nextInt(3), rand.nextInt(3));
                    autoGood = tic.placeLetter(auto, 'O');
                }
                System.out.println(tic);
            }
            // check if the game is ongoing
            if (tic.getGameState() != GameState.ONGOING) {
                break;
            }
        }
        //printing the result
        if (tic.getGameState() == GameState.PLAYER1_WIN) {
            System.out.println("Player 1 wins!");
        } else if (tic.getGameState() == GameState.PLAYER2_WIN) {
            System.out.println("Player 2 wins!");
        } else {
            System.out.println("There is a tie!");
        }
    }

    public static void twoPlayerGame(Scanner sc) {
        Board tic = new Board();
        for (int i = 0; i < 9; i++) {
            if (i == 0) {
                System.out.println(tic);
            }
        //player 1's turn
            if (i % 2 == 0) {
                boolean goodLocation = false;
                // a while loop for player to enter the right location
                while (!goodLocation) {
                    Location l = getInput("1", sc);
                    if (tic.placeLetter(l, 'X')) {
                        goodLocation = true;
                    }
                }
                System.out.println(tic);
        //player 2's turn
            } else {
                boolean goodLocation = false;
                // a while loop for player to enter the right location
                while (!goodLocation) {
                    Location l = getInput("2", sc);
                    if (tic.placeLetter(l, 'O')) {
                        goodLocation = true;
                    }
                }
                System.out.println(tic);
            }
            if (tic.getGameState() != GameState.ONGOING) {
                break;
            }
        }
        if (tic.getGameState() == GameState.PLAYER1_WIN) {
            System.out.println("Player 1 wins!");
        } else if (tic.getGameState() == GameState.PLAYER2_WIN) {
            System.out.println("Player 2 wins!");
        } else {
            System.out.println("There is a tie!");
        }
    }
    /********************************************************
     *                                                      *
     *      DO NOT MODIFY CODE BELOW THIS BOX               *
     *                                                      *
     ********************************************************/

   /**
     * Gets number of players from command line
     * @param sc        for reading from command-line
     * @return number of players (always 1 or 2)
     */
    private static int getNumberPlayers(Scanner sc) {
        boolean repeatPrompt = true;
        int numPlayers = 0;
        while (repeatPrompt) {
            System.out.print("How many players (1 or 2)? ");
            String input = sc.next();
            try {
                numPlayers = Integer.parseInt(input);
                if (numPlayers == 1 || numPlayers == 2) {
                    repeatPrompt = false;
                } else {
                    System.out.println("Enter 1 or 2 players.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please only enter a number.");
            }
        }
        return numPlayers;
    }

   /**
     * Handles scanner calls and user input
     * @param player    whose turn it is
     * @param sc        for reading from command-line
     * @return int[] holding row, column in that order
     */
    private static Location getInput(String player, Scanner sc) {
        boolean repeatPrompt = true;
        int row = -1;
        int col = -1;
        while (repeatPrompt) {
            System.out.print("Enter desired square for " + player + ": ");
            String input = sc.next();
            input = input.trim();
            String[] splitInput = input.split(",");
            try {
                row = Integer.parseInt(splitInput[0]);
                col = Integer.parseInt(splitInput[1]);
                repeatPrompt = false;
            } catch (NumberFormatException | IndexOutOfBoundsException e) {
                System.out.println("Please follow the format 'row,col'; for ex '1,2'");
            }
        }
        Location loc = new Location(row, col);
        return loc;
    }

}


