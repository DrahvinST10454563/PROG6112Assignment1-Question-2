
package game;

public class Battleship extends Ship {
    public Battleship(int x, int y, boolean isHorizontal) {
        super(4, x, y, isHorizontal);
    }

    @Override
    public boolean isHit(int x, int y) {
        if (isHorizontal) {
            if (y == this.y && x >= this.x && x < this.x + size) {
                hits[x - this.x] = true;
                return true;
            }
        } else {
            if (x == this.x && y >= this.y && y < this.y + size) {
                hits[y - this.y] = true;
                return true;
            }
        }
        return false;
    }
}
