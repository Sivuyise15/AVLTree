import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/** A programme that uses AVLTree data structure to store and search data from it, to check its credibility
 * @Author Sivuyise Matwa
 * Date: 20 March 2024
 */

public class AVLTest {
    /** Storage of the data
     */
    AVLTree<String> dataBase = new AVLTree<>();
    /** to check when the file is found
     */
    boolean found = false;
    /** The file to read from
     */
    File the_file;

    /** Read data from the file and store it in the AVL data structure
     * @param file_name
     */
    public void data(String file_name){
        the_file = new File(file_name);
        try(Scanner scanner = new Scanner(the_file)){
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] parts = line.split("\t");
                String term;
                String statement;
                String score;
                term = parts[0];
                statement = parts[1];
                score = parts[2];
                dataBase.insert(term, statement, score);
            }
            scanner.close();
            System.out.println("\ndatabase loaded\n");
            found = true;
        }
        catch (FileNotFoundException e){
            System.err.println("\nFile not found "+e+"\n");
        }
    }

    /** For the given file, read and search for the corresponding data in the data set and
     * write the results to external file
     * @param fileName
     */

    public void match(String fileName){
        int count = 0;
        File fName = new File(fileName);

        try(Scanner scan = new Scanner(fName)){
            FileWriter f = new FileWriter("results.txt");
            while(scan.hasNextLine()){
                String lin = scan.nextLine();
                String terms = dataBase.search(lin);
                String score = dataBase.searchScore(lin);
                if(terms == null){
                    count++;
                    f.write("Statement not found: "+lin+"\n");
                }
                else {
                    count++;
                    f.write("Statement found: " + terms + " (Confidence score: " +score+ ")"+"\n");
                }

            }
            f.write("Search comparisons " + dataBase.counter1+"\n");
            f.write("Insert comparisons " + dataBase.counter);



        } catch (FileNotFoundException e) {
            System.err.println("\nFile not found "+e+"\n");
        }
        catch(IOException e){

        }
    }
}