package Objects;

public class Point {
    public int x, y;

    public Point(){
        this.x = 0;
        this.y = 0;
    }

    public Point(int x, int y){
        this.setPos(x, y);
    }

    public void setPos(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void setPos(Point newPoint){
        this.x = newPoint.x;
        this.y = newPoint.y;
    }

    public void print(){
        System.out.println("(" + this.x + ", " + this.y + ")");
    }
}
