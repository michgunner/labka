package classes;

import java.util.Date;
import java.util.Objects;

public class Product {
    private long id;
    private String name;
    private Coordinates coordinates;
    private Date creationDate;
    private Double price;
    private UnitOfMeasure unitOfMeasure;
    private Person owner;

    public Product(long id, String name, Coordinates coordinates, Date creationDate,
                   double price, UnitOfMeasure unitOfMeasure, Person owner){
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.price = price;
        this.unitOfMeasure = unitOfMeasure;
        this.owner = owner;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setUnitOfMeasure(UnitOfMeasure unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public double getPrice() {
        return price;
    }

    public long getId() {
        return id;
    }

    public Person getOwner() {
        return owner;
    }

    public String getName() {
        return name;
    }

    public UnitOfMeasure getUnitOfMeasure() {
        return unitOfMeasure;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || o.getClass() != this.getClass())
            return false;
        Product lol = (Product) o;
        return id == lol.id
                && Objects.equals(name, lol.name)
                && Objects.equals(coordinates, lol.coordinates)
                && Objects.equals(creationDate, lol.creationDate)
                && Objects.equals(price, lol.price)
                && Objects.equals(unitOfMeasure, lol.unitOfMeasure)
                && Objects.equals(owner, lol.owner);
    }
    @Override
    public String toString(){
        return "Product { \n" + " id = " + id + ",\n name = '" + name + '\'' + ",\n coordinates"
                + coordinates + ",\n creationDate = " + creationDate + ",\n price = " + price +
                ",\n unitOfMeasure = " + unitOfMeasure + ",\n owner = " + owner;
    }
    @Override
    public int hashCode(){
        return Objects.hash(id, name, coordinates, creationDate, price, unitOfMeasure, owner);
    }
}
