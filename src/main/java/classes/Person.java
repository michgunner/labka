package classes;

import java.time.LocalDateTime;

public class Person {
    private String name;
    private LocalDateTime birthday;
    private Double weight;
    private Color hairColor;
    private Country nationality;

    public Person(String name, LocalDateTime birthday, double weight, Color hairColor, Country nationality){
        this.name = name;
        this.birthday = birthday;
        this.weight = weight;
        this.hairColor = hairColor;
        this.nationality = nationality;
    }

    public String getName(){
        return name;
    }
    @Override
    public String toString(){
        return "Owner{ " + "name: " + name + "; birthday: " + birthday + "; weight: " + weight
                + "; hair color: " + hairColor + "; nationality: " + nationality + "}";
    }
}
