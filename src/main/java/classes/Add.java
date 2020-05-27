package classes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Add {
    public static String Name() {
        String a = null;
        while (a == null) {
            Scanner s = new Scanner(System.in);
            System.out.println("Type Product's name: ");
            a = s.nextLine();
            if (a.length() == 0) {
                a = null;
                System.out.println("Name can't be empty");
                continue;
            } else {
                System.out.println("Name is added!");
            }
        }
        return a;
    }

    public static Float X() {
        Float x = null;
        while (x == null) {
            Scanner s = new Scanner(System.in);
            System.out.println("coordinate x (max 696) : ");
            try {
                x = s.nextFloat();
                if (x > 696) throw new Exception();
            } catch (Exception e) {
                System.out.println("Wrong type(need float) and less than 696");
                x = null;
                continue;
            }
        }
        return x;
    }

    public static Integer Y() {
        Integer y = null;
        while (y == null) {
            Scanner s = new Scanner(System.in);
            System.out.println("coordinate y (min -126): ");
            try {
                y = s.nextInt();
                if (y < -126) throw new Exception();
            } catch (Exception e) {
                System.out.println("Wrong type (need integer) and greater than -126");
                y = null;
                continue;
            }
        }
        return y;
    }

    public static Double Price() throws IOException {
        double d = -1;
        while (d == -1) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Product price is: ");
            try {
                d = Double.parseDouble(reader.readLine());
                if (d < 0) throw new Exception();
            } catch (Exception e) {
                System.out.println("Wrong type (need double) or greater than 0");
                d = -1;
                continue;
            }
        }
        return d;
    }

    public static UnitOfMeasure UOM() {
        UnitOfMeasure u = null;
        while (u == null) {
            System.out.println("Choose unit of measure: kilograms, pcs or liters");
            try {
                Scanner s = new Scanner(System.in);
                String string = s.nextLine();
                if (string == null)
                    u = null;
                else
                    u = UnitOfMeasure.valueOf(string.toUpperCase().trim());
            } catch (IllegalArgumentException e) {
                System.out.println("wrong input");
                u = null;
                continue;
            }
        }
        return u;
    }

    public static String OwnerName() {
        String name = null;
        while (name == null) {
            Scanner s = new Scanner(System.in);
            System.out.println("Type owner's name: ");
            name = s.nextLine();
            if (name.length() == 0) {
                name = null;
                System.out.println("Name can't be empty");
                continue;
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
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                weight = Double.parseDouble(reader.readLine());
                if (weight <= 0) throw new Exception();
            } catch (Exception e) {
                System.out.println("Type weight in numbers greater than 0");
                weight = null;
                continue;
            }
        }
        return weight;
    }

    public static Color Haircolor() {
        Color hairColor = null;
        while (hairColor == null) {
            System.out.println("Type owner's hair color: red, black, yellow or brown ");
            try {
                Scanner scanner = new Scanner(System.in);
                String a = scanner.nextLine();
                hairColor = Color.valueOf(a.toUpperCase().trim());
            } catch (Exception e) {
                System.out.println("You need to type one of 4 colors");
                hairColor = null;
                continue;
            }
        }
        return hairColor;
    }

    public static Country Nation() {
        Country nation = null;
        while (nation == null) {
            System.out.println("Type owner's country: France, Italy ot North_Korea");
            try {
                Scanner scanner = new Scanner(System.in);
                String a = scanner.nextLine();
                nation = Country.valueOf(a.toUpperCase().trim());
            } catch (Exception e) {
                System.out.println("You need to type one of 3 countries");
                nation = null;
                continue;
            }
        }
        return nation;
    }

    public static LocalDateTime Birthday() {
        LocalDateTime dateTime = null;
        while (dateTime == null) {
            System.out.println("Type owner's birthday in format yyyy-MM-dd hh:mm");
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                String a = reader.readLine();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                dateTime = LocalDateTime.parse(a, formatter);
            } catch (Exception e) {
                System.out.println("check format");
                dateTime = null;
                continue;
            }
        }
        return dateTime;
    }
}