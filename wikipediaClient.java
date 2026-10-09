import java.io.*;
import java.nio.file.*;
import java.util.*;
public class wikipediaClient {
    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to the unofficial offline Wikipedia client!");
        Scanner read = new Scanner(System.in);
        Path wikipediaSource = Paths.get("/home/" + System.getProperty("user.name") + "/wikipedia.txt");
        Object[] lines = Files.readAllLines(wikipediaSource).toArray();
        String userInput = "";
        while (!userInput.equals("{exit}")) {
            System.out.println("What would you like to search for? (type '{exit}' to exit)");
            userInput = read.nextLine();
            String[] capitalisedUserInputList = userInput.split(" ");
            String capitalisedUserInput = "";
            int i = 0;
            while (i != capitalisedUserInputList.length) {
                capitalisedUserInput = capitalisedUserInput.concat(capitalisedUserInputList[i].substring(0, 1).toUpperCase() + capitalisedUserInputList[i].substring(1, capitalisedUserInputList[i].length())) + " ";
                i++;
            }
            long lineStart = Arrays.asList(lines).indexOf(capitalisedUserInput.substring(0, capitalisedUserInput.length() - 1));
            try {
                while (!lines[((int) lineStart)].equals("") || !lines[((int) lineStart) + 1].equals("")) {
                    System.out.println(lines[((int) lineStart)]);
                    lineStart++;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Couldn't be found :(");
            }
        }
    }
}
