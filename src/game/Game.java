
package game;
import static java.lang.Math.random;
import java.util.Scanner;
import java.util.Random;

public class Game {

    public static void main(String[] args) {
      // Create a scanner to read user input from the console
Scanner scanner = new Scanner(System.in);

// Initialize the game board with a size of 4 (assuming a 4x4 grid)
GameBoard board = new GameBoard(4);

// Create an instance of Random to generate random numbers
Random random = new Random();

// Define the upper bound for random number generation (0 to 8)
int upperbound = 9;

// Generate random coordinates for placing the ships
int int_random = random.nextInt(upperbound); // Random x-coordinate for first ship
int random2 = random.nextInt(upperbound); // Random y-coordinate for first ship
int random3 = random.nextInt(upperbound); // Random x-coordinate for second ship
int random4 = random.nextInt(upperbound); // Random y-coordinate for second ship

// Add two ships to the game board with the generated coordinates
// First ship placed horizontally
board.addShip(new Battleship(int_random, random2, true));
// Second ship placed vertically
board.addShip(new Battleship(random3, random4, false));

// Flag to keep track of whether the game is still running
boolean gameRunning = true;

// Main game loop that continues while the game is running
while (gameRunning) {
    // Display the current state of the game board
    board.displayBoard();
    
    // Prompt the user to enter attack coordinates
    System.out.println("Enter attack coordinates (x y): ");
    int x = scanner.nextInt(); // Read the x-coordinate for the attack
    int y = scanner.nextInt(); // Read the y-coordinate for the attack

    // Perform the attack on the board with the given coordinates
    boolean hit = board.attack(x, y);
    if (hit) {
        // Notify the user if the attack was a hit
        System.out.println("Hit!");
    } else {
        // Notify the user if the attack was a miss
        System.out.println("Miss!");
    }

    // Add logic to end the game when all ships are sunk
    // For simplicity, end the game after one attack
    gameRunning = false;
}

// Close the scanner to release system resources
scanner.close();
    }
}