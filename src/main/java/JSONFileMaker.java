import java.io.FileWriter;
import java.io.IOException;

public class JSONFileMaker {
    public static void main(String[] args) {
        Util.getDriver().get("https://jsonplaceholder.typicode.com/posts/");
        String jsonString = "This file is nothing";
        try {
            FileWriter myWriter = new FileWriter("referencePosts.json");
            myWriter.write(jsonString);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
