import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        if (args.length==0 ){
            System.out.println("net faila");
            System.exit(-1);
        }
        new Work().start(args[0], new Scanner(System.in));

    }
}
//executeScript commands