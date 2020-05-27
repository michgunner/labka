import java.io.IOException;
import java.util.Scanner;

public class Work {
    Commands commands = new Commands();
    public static Scanner scanner = new Scanner(System.in);
    public Work() throws IOException {
    }

    void start(String a) throws InterruptedException, IOException {
        commands.start(a);
        boolean v = true;
        String[] arsenal = new String[]{"", ""};
        while(v){
            System.out.println("Type command:");
            try {
                a = scanner.nextLine();
                a.toLowerCase();
                arsenal = a.split(" ");
            }catch (Exception e){
                scanner = new Scanner(System.in);
            }
            if (arsenal[0].equals("exit")){
                v = false;
            }
            switch (arsenal[0]){
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
                case "update":
                    if (arsenal.length==1){
                        System.out.println("need to type id");
                        continue;
                    }else {
                        try {
                            commands.update(Long.valueOf(arsenal[1]));
                            break;
                        }catch (Exception e){
                            System.out.println("Long needed");
                            break;
                        }
                    }
                case "remove_by_id":
                    if (arsenal.length==1){
                        System.out.println("need to type id");
                        continue;
                    }else {
                        try {
                            commands.remove_by_id(Long.valueOf(arsenal[1]));
                            break;
                        } catch (NullPointerException f) {
                            System.out.println("no such element");
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
                case "execute_script":
                    if (arsenal.length==1){
                        System.out.println("need to type file");
                        continue;
                    }else {
                        try {
                            commands.execute_script(arsenal[1]);
                            break;
                        } catch (Exception e) {
                            System.out.println("No such file");
                        }
                    }
                case "exit":
                    commands.exit();
                    break;
                case "remove_at":
                    if (arsenal.length==1){
                        System.out.println("need to type index");
                        continue;
                    }else {
                        try {
                            commands.remove_at(Integer.valueOf(arsenal[1]));
                            break;
                        } catch (Exception e) {
                            System.out.println("int needed");
                            continue;
                        }
                    }
                case "add_if_max":
                    if (arsenal.length == 1){
                        System.out.println("need to type price");
                        continue;
                    }else {
                        try {
                            commands.add_if_max(Double.valueOf(arsenal[1]));
                            break;
                        }catch (Exception e){
                            System.out.println("double needed");
                            continue;
                        }
                    }
                case "shuffle":
                    commands.shuffle();
                    break;
                case "filter_by_owner":
                    if (arsenal.length==1){
                        System.out.println("need to type owner's name");
                        continue;
                    }else {
                        commands.filter_by_owner(arsenal[1]);
                        break;
                    }
                case "filter_contains_name":
                    if (arsenal.length==1){
                        System.out.println("need to type owner's name");
                        continue;
                    }else {
                            commands.filter_contains_name(arsenal[1]);
                            break;
                        }
                case "print_field_descending_price":
                    commands.print_field_descending_price();
                    break;
                default:
                    System.out.println("No such command");
                    break;
            }
        }
    }
}
