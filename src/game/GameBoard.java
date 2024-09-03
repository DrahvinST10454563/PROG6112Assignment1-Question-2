
package game;


public class GameBoard {
    private char[][] board;
    private Ship[] ships;

   // Constructor to initialize the game board with a given number of ships
public GameBoard(int numShips) {
    // Create a 2D array for the board (11x11) and initialize all cells to '.'
    board = new char[11][11];
    for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < board[i].length; j++) {
            board[i][j] = '.'; // '.' represents an empty cell
        }
    }
    // Initialize the array to hold the ships
    ships = new Ship[numShips];
}

// Method to add a ship to the board
public void addShip(Ship ship) {
    // Place the ship on the board based on its orientation (horizontal or vertical)
    for (int i = 0; i < ship.getSize(); i++) {
        if (ship.isHorizontal) {
            board[ship.y][ship.x + i] = 'S'; // 'S' represents a ship
        } else {
            board[ship.y + i][ship.x] = 'S'; // 'S' represents a ship
        }
    }
    // Add the ship to the list of ships
    for (int i = 0; i < ships.length; i++) {
        if (ships[i] == null) { // Find the first empty slot
            ships[i] = ship; // Store the ship
            break;
        }
    }
}

// Method to perform an attack on the board at specified coordinates
public boolean attack(int x, int y) {
    if (board[y][x] == 'S') { // Check if the cell contains a ship
        board[y][x] = 'H'; // Mark the cell as hit ('H')
        for (Ship ship : ships) {
            if (ship.isHit(x, y)) { // Check if the ship is hit
                return true; // Return true if a ship is hit
            }
        }
    } else {
        board[y][x] = 'M'; // Mark the cell as miss ('M')
    }
    return false; // Return false if no ship is hit
}

// Method to display the current state of the game board
public void displayBoard() {
    for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < board[i].length; j++) {
            System.out.print(board[i][j] + " "); // Print each cell's content
        }
        System.out.println(); // Move to the next line after each row
    }
}

}
