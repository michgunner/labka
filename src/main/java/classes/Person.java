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
    public void setName(String name){
        this.name = name;
    }
    public void setBirthday(LocalDateTime birthday){
        this.birthday = birthday;
    }
    public void setWeight(double weight){
        this.weight = weight;
    }
    public void setHairColor(Color hairColor){
        this.hairColor = hairColor;
    }
    public void setNationality(Country nationality){
        this.nationality = nationality;
    }
    public String getName(){
        return name;
    }
    public LocalDateTime getBirthday(){
        return birthday;
    }
    public double getWeight(){
        return weight;
    }
    public Color getHairColor(){
        return hairColor;
    }
    public Country getNationality(){
        return nationality;
    }
    @Override
    public String toString(){
        return "Owner{ " + "name: " + name + "; birthday: " + birthday + "; weight: " + weight
                + "; hair color: " + hairColor + "; nationality: " + nationality + "}";
    }
}
