import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class APITest {

    public static final String url = "https://jsonplaceholder.typicode.com/posts";

    @Test
    public void testValidURL() {
        Response response = RestAssured.given()
                .relaxedHTTPSValidation()
                .header("Content-Type", "application/json")
                .when()
                .get(url);

        Assertions.assertEquals(200, response.getStatusCode());
    }
/*

    @Test
    public void testJSONPosts() {
        Response response = null;
        response = RestAssured.given()
                .relaxedHTTPSValidation()
                .header("Content-Type", "application/json")
                .when()
                .get(url);
        String expected = "";
        try{
            File myObj = new File("posts.json");
            Scanner scanner = new Scanner(myObj);
                while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                expected += data;
                }
            }
        catch (FileNotFoundException e) {
            System.out.println("Error occured");
            e.printStackTrace();
        }

        JsonArray array = response.getBody().as(JsonArray.class);
        Assertions.assertEquals(expected, array.toString());
    }

    @Test
    public void testJSONBody() {
        Response response = null;
        response = RestAssured.given()
                .relaxedHTTPSValidation()
                .header("Content-Type", "application/json")
                .when()
                .get(url);

        JsonArray array = response.getBody().as(JsonArray.class);
        System.out.println(array);
        JsonObject obj = array.get(0).getAsJsonObject();
        Set<Map.Entry<String, JsonElement>> entries = obj.entrySet();    //will return members of your object
        for (Map.Entry<String, JsonElement> entry: entries) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
*/
}
