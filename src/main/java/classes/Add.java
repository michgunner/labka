package classes;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Add {
    private static Scanner scanner = new Scanner(System.in);
    public static String Name() {
        String name = null;
        while (name == null) {
            System.out.println("Type Product's name: ");
            name = scanner.nextLine();
            if (name.length() == 0) {
                System.out.println("Name can't be empty");
            } else {
                System.out.println("Name is added!");
            }
        }
        return name;
    }

    public static Float X() {
        Float x = null;
        while (x == null) {
            System.out.println("coordinate x (max 696) : ");
            try {
                x = scanner.nextFloat();
                if (x > 696) {
                    System.out.println("need to be less than 696");
                    x = null;
                }
            } catch (Exception e) {
                System.out.println("Wrong type(need float)");
                x = null;
                scanner.nextLine();
            }
        }
        return x;
    }

    public static Integer Y() {
        Integer y = null;
        while (y == null) {
            System.out.println("coordinate y (min -126): ");
            try {
                y = scanner.nextInt();
                if (y < -126) {
                    System.out.println("need to be more than -126");
                    y=null;
                }
            } catch (Exception e) {
                System.out.println("Wrong type (need integer)");
                y = null;
                scanner.nextLine();
            }
        }
        scanner.nextLine();
        return y;
    }

    public static Double Price() {
        double price = -1;
        while (price < 0) {
            System.out.println("Product price is: ");
            try {
                price = Double.parseDouble(scanner.nextLine());
                if (price<0){
                    System.out.println("price cannot be less than 0");
                }else
                System.out.println("Price is added");
            } catch (Exception e) {
                System.out.println("Wrong type (need double)");
                price = -1;
            }
        }
        return price;
    }

    public static UnitOfMeasure UOM() {
        UnitOfMeasure unitOfMeasure = null;
        while (unitOfMeasure == null) {
            System.out.println("Choose unit of measure: kilograms, pcs or liters");
            try {
                String string = scanner.nextLine();
                unitOfMeasure = UnitOfMeasure.valueOf(string.toUpperCase().trim());
            } catch (IllegalArgumentException e) {
                System.out.println("wrong input");
                unitOfMeasure = null;
            }
        }
        return unitOfMeasure;
    }

    public static String OwnerName() {
        String name = null;
        while (name == null) {
            System.out.println("Type owner's name: ");
            name = scanner.nextLine();
            if (name.length() == 0) {
                System.out.println("Name can't be empty");
            } else {
                System.out.println("Name is added!");
            }
        }
        return name;
    }

    public static Double OwnerWeight() {
        Double weight = null;
        while (weight == null) {
            System.out.println("Type owner's weight: ");
            try {
                weight = Double.parseDouble(scanner.nextLine());
                if (weight <= 0){
                    System.out.println("weight can't be less then 1");
                    weight = null;
                }
            } catch (Exception e) {
                System.out.println("wrong type(need double)");
                weight = null;
            }
        }
        return weight;
    }

    public static Color HairColor() {
        Color hairColor = null;
        while (hairColor == null) {
            System.out.println("Type owner's hair color: red, black, yellow or brown ");
            try {
                String a = scanner.nextLine();
                hairColor = Color.valueOf(a.toUpperCase().trim());
            } catch (IllegalArgumentException e) {
                System.out.println("You need to type one of 4 colors");
                hairColor = null;
            }
        }
        return hairColor;
    }

    public static Country Nation() {
        Country nation = null;
        while (nation == null) {
            System.out.println("Type owner's country: France, Italy ot North_Korea");
            try {
                String a = scanner.nextLine();
                nation = Country.valueOf(a.toUpperCase().trim());
            } catch (IllegalArgumentException e) {
                System.out.println("You need to type one of 3 countries");
                nation = null;
            }
        }
        return nation;
    }

    public static LocalDateTime Birthday() {
        LocalDateTime dateTime = null;
        while (dateTime == null) {
            System.out.println("Type owner's birthday in format yyyy-MM-dd hh:mm");
            try {
                String a = scanner.nextLine();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                dateTime = LocalDateTime.parse(a, formatter);
            } catch (Exception e) {
                System.out.println("check format");
                dateTime = null;
            }
        }
        return dateTime;
    }
}