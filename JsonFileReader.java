import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class JsonFileReader  {
    public List<DataObject> readJsonFile(String filePath) {
        try {
            Gson gson = new Gson();// Creates a Gson object for JSON parsing
            FileReader reader = new FileReader(filePath);// Creates a FileReader to read the JSON file

            //används för att hålla den generiska typinformationen (List of DataObject) som annars skulle gå förlorad på grund av typradering
            Type dataListType = new TypeToken<List<DataObject>>() {}.getType();
            // Parse ( to get relevant pieces of information)  the JSON data from the file into a List<DataObject> using Gson
            return gson.fromJson(reader, dataListType);
        } catch (IOException e) {

            e.printStackTrace();// Print the stack trace if an IOException occurs
            return null;// Return null if an exception occurs (file reading failure)
        }
    }
}
