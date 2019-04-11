package arena;

public class Position {

    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Position sum (Position pos){
        return new Position(this.x + pos.getX(), this.y + pos.getY());
    }

    public boolean isOnTheBoard(){
        return !(x < 0 && x > 15 && y < 0 && y > 15);
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
}
