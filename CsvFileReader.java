import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvFileReader {
    public List<DataObject> readCsvFile(String filePath) {
        List<DataObject> dataObjects = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",",8); // based on CSV format
                DataObject dataObject = new DataObject();
                dataObject.setA(values[0]);
                dataObject.setB(values[1]);
                dataObject.setC(values[2]);
                dataObject.setD(values[3]);
                dataObject.setE(values[4]);
                dataObject.setF(values[5]);
                dataObject.setG(values[6]);
                dataObject.setH(values[7]);


                dataObjects.add(dataObject);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dataObjects;
    }
}

