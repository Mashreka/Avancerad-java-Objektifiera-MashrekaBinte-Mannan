import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvFileReader {
    public List<DataObject> readCsvFile(String filePath) {

        //Create a list to store the DataObject instances
        List<DataObject> dataObjects = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Split the line into an array of values based on the CSV format
                String[] values = line.split(",",8); // Here, ',' is the delimiter, and 8 is the limit of split parts
               // Create a new DataObject instance and set its fields using the values from the CSV file
                DataObject dataObject = new DataObject();
                dataObject.setA(values[0]);
                dataObject.setB(values[1]);
                dataObject.setC(values[2]);
                dataObject.setD(values[3]);
                dataObject.setE(values[4]);
                dataObject.setF(values[5]);
                dataObject.setG(values[6]);
                dataObject.setH(values[7]);

                // Add the DataObject instance to the list
                dataObjects.add(dataObject);
            }
        } catch (IOException e) {
            e.printStackTrace();// Print stack trace if an IOException occurs during file reading
        }
        // Return the list of DataObject instances populated from the CSV file
        return dataObjects;
    }
}

