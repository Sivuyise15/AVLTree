import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

//GenericsKB-queries.txt

public class GenericsKbAVLApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter file name to load database: ");
        String fileName = scanner.nextLine();

        AVLTest kb = new AVLTest();
        kb.data(fileName);
        int opt;

        if (kb.found) {
            System.out.print("Enter file name to query "+ fileName+": ");
            String fName = scanner.nextLine();
            kb.match(fName);
        }
        System.out.println("Insert comparisons made: " + kb.dataBase.counter);
        System.out.println("Search comparisons made: " + kb.dataBase.counter1);
    }
}