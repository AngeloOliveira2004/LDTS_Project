package org.space.invaders.model;
public class Position {
    public int x;
    public int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if(o == null || o.getClass() != this.getClass()) return false;

        return (this == o) ||
                (this.x == ((Position) o).x && this.y == ((Position) o).y);
    }
    public Position clone(){
        return new Position(x,y);
    }
    @Override
    public int hashCode() {
        return Integer.hashCode(x) ^ Integer.hashCode(y);
    }

    public double distanceTo(Position other) {
        int deltaX = other.x - this.x;
        int deltaY = other.y - this.y;
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }
}

