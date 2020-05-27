import classes.*;

import java.io.*;
import java.time.LocalDateTime;
import java.util.*;
import classes.Coordinates;
import classes.Person;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Commands {
    ArrayList<Product> array = new ArrayList<>();
    public Commands(){
    }
    private LocalDateTime dateTime = LocalDateTime.now();
    String json;
    String file;

    void start(String a) throws InterruptedException {
        file = a;
        try{
            FileInputStream fin = new FileInputStream(a);
            String arsenal = "";
            char c;
            int j = 0;
            while (j != -1) {
                j = fin.read();
                c = (char) j;
                if (j == -1) continue;
                arsenal = arsenal.concat(String.valueOf(c));
                }
            Gson gson = new Gson();
            array = gson.fromJson(arsenal,new TypeToken<ArrayList<Product>>(){}.getType());
            if(array.size()==0){
                System.out.println(" ");
            }
        }catch (Exception e){
            System.out.println("Error with file");
            System.exit(0);
        }
        System.out.println("HI!");
        Thread.sleep(1000);
        System.out.println("It's a collection's management program.");
        Thread.sleep(1000);
        System.out.println("Type \"help\" to see commands.");
    }
    void help(){
        System.out.println("help : вывести справку по доступным командам\n"+
                "info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.\n"+
                "show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении\n" +
                "add {element} : добавить новый элемент в коллекцию\n"+
                "update id {element} : обновить значение элемента коллекции, id которого равен заданному\n"+
                "remove_by_id id : удалить элемент из коллекции по его id\n"+
                "clear : очистить коллекцию\n"+
                "save : сохранить коллекцию в файл\n"+
                "execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.\n"+
                "exit : завершить программу (без сохранения в файл)\n"+
                "remove_at index : удалить элемент, находящийся в заданной позиции коллекции (index)\n"+
                "add_if_max {element} : добавить новый элемент в коллекцию, если его значение цены превышает значение наибольшего элемента этой коллекции\n"+
                "shuffle : перемешать элементы коллекции в случайном порядке\n"+
                "filter_by_owner owner : вывести элементы, значение поля owner которых равно заданному\n"+
                "filter_contains_name name : вывести элементы, значение поля name которых содержит заданную подстроку\n"+
                "print_field_descending_price : вывести значения поля price всех элементов в порядке убывания\n");
    }
    void info(){
        System.out.println("Collection's type is " + array.getClass() + ". \n" +
                "Date of initialization is " + dateTime + ". \n" +
                "Size of collection is " + array.size());
    }
    void show(){
        if (array.isEmpty()){
            System.out.println("Collection is empty");
        }else
            for (Product a : array){
                System.out.println("This is all elements of collection:");
                System.out.println(a);
        }
    }
    void add() throws IOException {
        int id  = array.size();
        for (Product a : array) {
            if (a.getId()==id)
                id+=100;
        }
        String name = Add.Name();
        float x = Add.X();
        int y = Add.Y();
        double price = Add.Price();
        UnitOfMeasure uom = Add.UOM();
        String ownerName = Add.OwnerName();
        LocalDateTime ownerBirthday = Add.Birthday();
        double weight = Add.OwnerWeight();
        Color hair = Add.Haircolor();
        Country nation = Add.Nation();
        array.add(new Product(id, name, new Coordinates(x, y), new Date(), price, uom,
                new Person(ownerName, ownerBirthday, weight, hair, nation)));
        json = new Gson().toJson(array);
        System.out.println("Element added");
    }
    void update(long a) throws IOException {
        for (Product b : array){
            if (a==b.getId()){
                boolean c = true;
                while (c){
                    System.out.println("Type what you want to update");
                    System.out.println("To exit this command type 'exit'");
                    Scanner scanner = new Scanner(System.in);
                    String r = scanner.nextLine().toLowerCase();
                    switch (r) {
                        case "name":
                            String name = Add.Name();
                            b.setName(name);
                            System.out.println("Name updated");
                            break;
                        case "coordinates":
                            float x = Add.X();
                            int y = Add.Y();
                            b.setCoordinates(new Coordinates(x,y));
                            System.out.println("Coordinates updated");
                            break;
                        case "price":
                            double price = Add.Price();
                            b.setPrice(price);
                            System.out.println("Price updated");
                            break;
                        case "unit of measures":
                            UnitOfMeasure uom = Add.UOM();
                            b.setUnitOfMeasure(uom);
                            System.out.println("Unit of measures updated");
                            break;
                        case "owner":
                            String name1 = Add.OwnerName();
                            LocalDateTime birthday = Add.Birthday();
                            Double weight = Add.OwnerWeight();
                            Color hair = Add.Haircolor();
                            Country nation = Add.Nation();
                            b.setOwner(new Person(name1,birthday,weight,hair,nation));
                            System.out.println("Owner updated");
                            break;
                        case "exit":
                            c = false;
                            break;
                    }
                }
            }
        }
    }
    void remove_by_id(long a){
        Long wilshere = 0L;
        try {
            wilshere = a;
        }catch(Exception e){
            System.out.println("id is long type");
        }
        Product product = null;
        for (Product product1 : array) {
            long newId = product1.getId();
            if(wilshere==newId) {
                product = product1;
            }
        }
        if (product.getName().isEmpty()){
            System.out.println("No element with such id");
        }else
            array.remove(product);
        System.out.println("removed");
    }
    void clear(){
        array.clear();
        System.out.println("Collection is clear");
    }
    void save() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        char array[] = json.toCharArray();
        int i=0;
        while(i<json.length()) {
            int j= array[i];
            i++;
            writer.write(j);
        }
        writer.close();
    }
    void execute_script(String file){
        try {
            InputStream fileInputStream = new FileInputStream(file);
            int i;
            ArrayList<Character> characters = new ArrayList<>();
            while((i=fileInputStream.read())!=-1){
                characters.add((char)i);
            }
            String x = "";
            for (char v : characters){
                x = x + v;
            }
            Work.scanner = new Scanner(x);
        }catch (Exception e) {
            System.out.println("no such file");
        }
    }
    void exit(){
        System.out.println("The program finished");
    }
    void remove_at(int a) throws IOException {
        if (a<array.size()) {
            array.remove(a);
            System.out.println("element deleted");
        }else
            System.out.println("No such element");
    }
    void add_if_max(double price){
        ArrayList<Double> doubles = new ArrayList<>();
        for (Product s : array) {
            doubles.add(s.getPrice());
        }
            if (price > Collections.max(doubles)) {
                System.out.println("It's the biggest price");
                System.out.println("Write product's data: ");
                int id = array.size();
                for (Product a : array) {
                    if (a.getId() == id)
                        id += 100;
                }
                String name = Add.Name();
                float x = Add.X();
                int y = Add.Y();
                UnitOfMeasure uom = Add.UOM();
                String ownerName = Add.OwnerName();
                LocalDateTime ownerBirthday = Add.Birthday();
                double weight = Add.OwnerWeight();
                Color hair = Add.Haircolor();
                Country nation = Add.Nation();
                array.add(new Product(id, name, new Coordinates(x, y), new Date(), price, uom,
                        new Person(ownerName, ownerBirthday, weight, hair, nation)));
                json = new Gson().toJson(array);
                System.out.println("Element added");
            }
            else
                System.out.println("Not maximum");
    }
    void shuffle(){
        Collections.shuffle(array);
    }
    void filter_by_owner(String a){
        int z = 0;
        for (Product p : array){
            if (a.equals(p.getOwner().getName())){
                System.out.println(p);
            }else
                z++;
        }
        if (z==array.size())
            System.out.println("no matches found");
    }
    void filter_contains_name(String a){
        int z = 0;
        for (Product p : array){
            if (p.getName().contains(a))
                System.out.println(p);
            else
                z++;
        }
        if (z==array.size())
            System.out.println("no matches found");
    }
    void print_field_descending_price(){
        ArrayList<Double> doubles = new ArrayList<>();
        for (Product s : array) {
            doubles.add(s.getPrice());
        }
        Collections.sort(doubles, Collections.reverseOrder());
        int i = 0;
        while(i<doubles.size()){
            for (Product p : array){
                if (p.getPrice()== doubles.get(i)) {
                    System.out.println(p);
                    continue;
            }
            }
            i++;
        }
    }
}
