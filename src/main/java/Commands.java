import classes.*;

import java.io.*;
import java.time.LocalDateTime;
import java.util.*;
import classes.Coordinates;
import classes.Person;
import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;

public class Commands {
    ArrayList<Product> array = new ArrayList<>();

    public Commands() {
    }

    private LocalDateTime dateTime = LocalDateTime.now();
    String json;
    String file;

    void start(String fileName){
        file = fileName;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            Gson gson = new Gson();
            array = gson.fromJson(reader, new TypeToken<List<Product>>() {
            }.getType());

        } catch (FileNotFoundException e) {
            System.out.println("no such file");
            System.exit(-1);
        } catch (Exception e) {
            System.out.println("wrong file");
            System.exit(-1);


        }

    }

    void help() {
        System.out.println("help : вывести справку по доступным командам\n" +
                "info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.\n" +
                "show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении\n" +
                "add {element} : добавить новый элемент в коллекцию\n" +
                "update id {element} : обновить значение элемента коллекции, id которого равен заданному\n" +
                "remove by id id : удалить элемент из коллекции по его id\n" +
                "clear : очистить коллекцию\n" +
                "save : сохранить коллекцию в файл\n" +
                "execute script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.\n" +
                "exit : завершить программу (без сохранения в файл)\n" +
                "remove_first : удалить первый элемент из коллекции\n" +
                "add if max {element} : добавить новый элемент в коллекцию, если его значение цены превышает значение наибольшего элемента этой коллекции\n" +
                "shuffle : перемешать элементы коллекции в случайном порядке\n" +
                "filter by owner owner : вывести элементы, значение поля owner которых равно заданному\n" +
                "filter contains name name : вывести элементы, значение поля name которых содержит заданную подстроку\n" +
                "print field descending price : вывести значения поля price всех элементов в порядке убывания\n");
    }

    void info() {
        System.out.println("Collection's type is " + array.getClass() + ". \n" +
                "Date of initialization is " + dateTime + ". \n" +
                "Size of collection is " + array.size());
    }

    void show() {
        if (array.isEmpty()) {
            System.out.println("Collection is empty");
        } else {
            System.out.println("This is all elements of collection:");
            for (Product product : array) {
                System.out.println(product);
            }
        }
    }

    void add() {
        int id = array.size()+100;
        for (Product product : array) {
            if (product.getId() == id)
                id += 100;
        }
        String name = Add.Name();
        float x = Add.X();
        int y = Add.Y();
        double price = Add.Price();
        UnitOfMeasure uom = Add.UOM();
        String ownerName = Add.OwnerName();
        LocalDateTime ownerBirthday = Add.Birthday();
        double weight = Add.OwnerWeight();
        Color hair = Add.HairColor();
        Country nation = Add.Nation();
        array.add(new Product(id, name, new Coordinates(x, y), new Date(), price, uom,
                new Person(ownerName, ownerBirthday, weight, hair, nation)));
        json = new Gson().toJson(array);
        System.out.println("Element added");
    }

    void update(long id){
        boolean existId = false;
            for (Product product : array) {
            if (product.getId() == id) {
                boolean cycle = true;
                existId = true;
                while (cycle) {
                    System.out.println("Type what you want to update");
                    System.out.println("To exit this command type 'exit'");
                    Scanner scanner = new Scanner(System.in);
                    String update = scanner.nextLine().toLowerCase().trim();
                    switch (update) {
                        case "name":
                            String name = Add.Name();
                            product.setName(name);
                            System.out.println("Name updated");
                            break;
                        case "coordinates":
                            float x = Add.X();
                            int y = Add.Y();
                            product.setCoordinates(new Coordinates(x, y));
                            System.out.println("Coordinates updated");
                            break;
                        case "price":
                            double price = Add.Price();
                            product.setPrice(price);
                            System.out.println("Price updated");
                            break;
                        case "unit of measures":
                            UnitOfMeasure uom = Add.UOM();
                            product.setUnitOfMeasure(uom);
                            System.out.println("Unit of measures updated");
                            break;
                        case "owner":
                            String name1 = Add.OwnerName();
                            LocalDateTime birthday = Add.Birthday();
                            Double weight = Add.OwnerWeight();
                            Color hair = Add.HairColor();
                            Country nation = Add.Nation();
                            product.setOwner(new Person(name1, birthday, weight, hair, nation));
                            System.out.println("Owner updated");
                            break;
                        case "exit":
                            cycle = false;
                            break;
                        default:
                            System.out.println("no such parameters. there are only: name;" +
                                    " coordinates; price; unit of measures or owner");
                    }
                }
            }
        }
            if (!existId){
                System.out.println("no such element");
            }
    }

    void removeId(long id) {
        boolean isExist = false;
        for (Product product : array) {
            if (product.getId() == id) {
                isExist = true;
                array.remove(product);
                System.out.println("removed");
            }
        }
        if (!isExist){
            System.out.println("No such element");
        }
    }

    void clear() {
        array.clear();
        System.out.println("Collection is clear");
    }

    void save() throws IOException {
        FileOutputStream outputStream = new FileOutputStream(file);
        Gson gson = new Gson();
        String element = gson.toJson(array, new TypeToken<ArrayList<Product>>() {
        }.getType());
        byte[] bytes = element.getBytes();
        outputStream.write(bytes);
    }


    void removeFirst(){
        array.remove(0);
    }

    void addMax(double price) {
        ArrayList<Double> doubles = new ArrayList<>();
        for (Product s : array) {
            doubles.add(s.getPrice());
        }
        if (price > Collections.max(doubles)) {
            System.out.println("It's the biggest price");
            System.out.println("Write product's data: ");
            add();
        } else
            System.out.println("Not maximum");
    }

    void shuffle() {
        Collections.shuffle(array);
        System.out.println("collection shuffled");
    }

    void filterOwner(String owner) {
        int z = 0;
        for (Product p : array) {
            if (owner.equals(p.getOwner().getName())) {
                System.out.println(p);
            } else
                z++;
        }
        if (z == array.size())
            System.out.println("no matches found");
    }

    void filterName(String name) {
        int z = 0;
        for (Product p : array) {
            if (p.getName().contains(name))
                System.out.println(p);
            else
                z++;
        }
        if (z == array.size())
            System.out.println("no matches found");
    }

    void printFieldDescendingPrice() {
        array.sort(new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return Double.compare(o1.getPrice(), o2.getPrice());
            }
        });
        Collections.reverse(array);
        for (Product product : array) {
            System.out.println(product);
        }
    }
}