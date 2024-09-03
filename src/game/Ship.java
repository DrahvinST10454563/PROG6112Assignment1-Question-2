
package game;


public abstract class Ship {
    protected int size;
    protected boolean[] hits;
    protected int x, y; // Starting position
    protected boolean isHorizontal;

    public Ship(int size, int x, int y, boolean isHorizontal) {
        this.size = size;
        this.x = x;
        this.y = y;
        this.isHorizontal = isHorizontal;
        this.hits = new boolean[size];
    }

    public abstract boolean isHit(int x, int y);

    public boolean isSunk() {
        for (boolean hit : hits) {
            if (!hit) return false;
        }
        return true;
    }

    public int getSize() {
        return size;
    }
}
