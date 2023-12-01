import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class JsonFileReader  {
    public List<DataObject> readJsonFile(String filePath) {
        try {
            Gson gson = new Gson();
            FileReader reader = new FileReader(filePath);

            Type dataListType = new TypeToken<List<DataObject>>() {}.getType();//används för att hålla den generiska typinformationen (List of DataObject) som annars skulle gå förlorad på grund av typradering
            return gson.fromJson(reader, dataListType);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
