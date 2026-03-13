import java.util.Random;
import java.util.Scanner;

class Navmaxia {
    static int[][] board = new int[7][7];
    static int[][] displayBoard = new int[7][7];
    static int placed_ships = 0;
    static int attempts = 0;
    static int hits = 0;
    static int misses = 0;
    static boolean[][] hitTracker = new boolean[7][7];

    // Μέθοδος για την εμφάνιση του πίνακα
    static void Board(boolean revealShips) {
        System.out.println("  1 2 3 4 5 6 7");
        for (int i = 0; i < 7; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < 7; j++) {
                if (revealShips && board[i][j] == 1) {
                    System.out.print("S ");
                } else if (revealShips && board[i][j] == 2) {
                    System.out.print("D ");
                } else if (displayBoard[i][j] == 1) {
                    System.out.print("Χ ");
                } else if (displayBoard[i][j] == -1) {
                    System.out.print("* ");
                } else {
                    System.out.print("~ ");
                }
            }
            System.out.println();
        }
    }

    static void Ships() {
        Random random = new Random();
        while (placed_ships < 4) {
            int rows = random.nextInt(7);
            int columns = random.nextInt(7);

            // Έλεγχος αν η θέση είναι ήδη κατειλημμένη
            if (board[rows][columns] != 0) {
                continue;
            }

            if (placed_ships < 2) {
                board[rows][columns] = 1;
                placed_ships++;
            } else {
                boolean horizontal = random.nextBoolean();
                if (horizontal && columns < 6 && board[rows][columns] == 0 && board[rows][columns + 1] == 0) {
                    board[rows][columns] = 2;
                    board[rows][columns + 1] = 2;
                    placed_ships++;
                } else if (!horizontal && rows < 6 && board[rows][columns] == 0 && board[rows + 1][columns] == 0) {
                    board[rows][columns] = 2;
                    board[rows + 1][columns] = 2;  
                    placed_ships++;
                }
            }
        }
    }

    static void player() {
        Scanner scanner = new Scanner(System.in);

        while (attempts < 10) {
            int row = -1;
            int col = -1;


            while (row < 1 || row > 7) {
                System.out.print("Enter where you want to hit. (Row: 1-7): ");
                if (scanner.hasNextInt()) {
                    row = scanner.nextInt();
                    if (row < 1 || row > 7) {
                        System.out.println("Error: Row must be between 1 and 7.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter an integer.");
                    scanner.next();
                }
            }


            while (col < 1 || col > 7) {
                System.out.print("Enter where you want to hit. (Col: 1-7): ");
                if (scanner.hasNextInt()) {
                    col = scanner.nextInt();
                    if (col < 1 || col > 7) {
                        System.out.println("Error: Column must be between 1 and 7.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter an integer.");
                    scanner.next();
                }
            }


            if (hitTracker[row - 1][col - 1]) {
                System.out.println("You already entered those coordinates! Try again.");
            } else {

                hitTracker[row - 1][col - 1] = true;
                results(row - 1, col - 1);
                attempts++;
                Board(false);
            }


            if (hits == placed_ships) {
                System.out.println("CONGRATULATIONS! You've destroyed all the ships!");
                break;
            }
        }


        System.out.println("Game Over! You scored:");
        System.out.println("Hits: " + hits);
        System.out.println("Misses: " + misses);

        Board(true);
        scanner.close();
    }


    static void results(int row, int col) {
        if (board[row][col] == 1 || board[row][col] == 2) {
            displayBoard[row][col] = 1;
            hits++;
            System.out.println("Χ - Hit!");
        } else {
            displayBoard[row][col] = -1;
            misses++;
            System.out.println("* - Miss!");

            boolean nearby = false;

            for (int i = 0; i < 7; i++) {
                if (board[row][i] == 1 || board[row][i] == 2 || board[i][col] == 1 || board[i][col] == 2) {
                    nearby = true;
                    break;
                }
            }

            if (nearby) {
                System.out.println("Hint: A ship is nearby in this row / column!");
            } else {
                System.out.println("No ships nearby in this row / column.");
            }
        }
    }

    public static void main(String... args) {
        Board(false);
        Ships();
        player();
    }
}
