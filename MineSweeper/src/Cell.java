public class Cell {
    private int coordX;
    private int coordY;
    private char identity;
    private boolean isBomb = false;

    public Cell(int coordX, int coordY, boolean isBomb) {
        this.coordX = coordX;
        this.coordY = coordY;
        this.isBomb = true;
        this.identity = '*';
    }
    public Cell(int coordX, int coordY) {
        this.coordX = coordX;
        this.coordY = coordY;
        this.identity = '#';
    }

    public int getCoordX() {
        return coordX;
    }

    public void setCoordX(int coordX) {
        this.coordX = coordX;
    }

    public int getCoordY() {
        return coordY;
    }

    public void setCoordY(int coordY) {
        this.coordY = coordY;
    }

    public char getIdentity() {
        return identity;
    }

    public void setIdentity(char identity) {
        this.identity = identity;
    }

    public boolean isBomb() {
        return isBomb;
    }

    public void setBomb(boolean bomb) {
        isBomb = bomb;
    }
    public String toString() {
        return identity+"";
    }
}
