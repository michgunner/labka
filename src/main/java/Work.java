import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Work {
    Commands commands = new Commands();
    private String file;
    void start(String arg, Scanner scanner) throws IOException {
        file = arg;
        commands.start(file);
        execute(scanner);
    }
    void execute(Scanner scanner) throws IOException {
        while(true){
            String[] inputString = new String[]{"", ""};
            System.out.println("Type command:");
            try {
                String a = scanner.nextLine().toLowerCase().trim();
                inputString = a.split(" ");
            }catch (Exception e){
                scanner = new Scanner(System.in);
            }
            switch (inputString[0]){
                case "help":
                    commands.help();
                    break;
                case "info":
                    commands.info();
                    break;
                case "show":
                    commands.show();
                    break;
                case "add":
                    commands.add();
                    break;
                case "updateid":
                    if (inputString.length==1){
                        System.out.println("need to type id");
                        continue;
                    }else {
                        try {
                            commands.update(Integer.parseInt(inputString[1]));
                            break;
                        }catch (Exception e){
                            System.out.println("id need to be int");
                            break;
                        }
                    }
                case "removebyid":
                    if (inputString.length==1){
                        System.out.println("need to type id");
                        continue;
                    }else {
                        try {
                            commands.removeId(Long.parseLong(inputString[1]));
                            break;
                        }
                        catch (Exception e){
                            System.out.println("Long needed");
                        }
                    }
                case "clear":
                    commands.clear();
                    break;
                case "save":
                    commands.save();
                    System.out.println("Collection saved");
                    break;
                case "executescript":
                    if (inputString.length==1){
                        System.out.println("need to type file");
                        continue;
                    }else {
                        try {
                            System.out.println("starting execution");
                            new Work().start(file, new Scanner(new File(inputString[1])));
                            break;
                        } catch (Exception e) {
                            System.out.println("No such file");
                        }
                    }
                case "exit":
                    System.exit(0);
                    break;
                case "removefirst":
                    commands.removeFirst();
                case "addifmax":
                    if (inputString.length == 1){
                        System.out.println("need to type price");
                        continue;
                    }else {
                        try {
                            commands.addMax(Double.parseDouble(inputString[1]));
                            break;
                        }catch (Exception e){
                            System.out.println("double needed");
                            continue;
                        }
                    }
                case "shuffle":
                    commands.shuffle();
                    break;
                case "filterbyownername":
                    if (inputString.length==1){
                        System.out.println("need to type owner's name");
                        continue;
                    }else {
                        commands.filterOwner(inputString[1]);
                        break;
                    }
                case "filtercontainsname":
                    if (inputString.length==1){
                        System.out.println("need to type owner's name");
                        continue;
                    }else {
                            commands.filterName(inputString[1]);
                            break;
                        }
                case "printfielddescendingprice":
                    commands.printFieldDescendingPrice();
                    break;
                default:
                    System.out.println("No such command");
                    break;
            }
        }
    }
}
