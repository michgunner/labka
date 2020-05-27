package classes;

public class Coordinates {
    private Float x;
    private Integer y;

    public Coordinates(Float x, Integer y) {
        this.x = x;
        this.y = y;
    }


    public void setX(Float x) {
        this.x = x;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public Float getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
