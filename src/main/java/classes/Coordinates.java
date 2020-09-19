package classes;

public class Coordinates {
    private Float x;
    private Integer y;

    public Coordinates(Float x, Integer y) {
        this.x = x;
        this.y = y;
    }
    @Override
    public String toString() {
        return "Coordinates{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
