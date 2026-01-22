import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        AVLTreeExam tree = new AVLTreeExam();

        // Numbers to insert
        int[] numbers = { 10, 20, 30, 40, 50, 25 };

        for (int number : numbers) {
            tree.insert(number);
        }

        // Writing the in-order traversal to a file
        try (FileWriter writer = new FileWriter("output.txt")) {
            tree.inOrder(writer);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("In-order traversal has been written to output.txt");
    }
}