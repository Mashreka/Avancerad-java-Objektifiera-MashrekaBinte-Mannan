import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

public class MainApp {
    private JFrame frame;
    private JTable table;
    private DefaultTableModel tableModel;
    private JsonFileReader jsonFileReader;
    private CsvFileReader csvFileReader;

    public MainApp() {
        jsonFileReader = new JsonFileReader();
        csvFileReader = new CsvFileReader();

        frame = new JFrame("File Reader App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        JButton jsonButton = new JButton("Read JSON File"); //Button för att ge action att läsa Json file
        jsonButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //för att välja vilken file ska jag läsa
                JFileChooser fileChooser = new JFileChooser("/Users/MashrekasMac/Desktop/Avancerad-java-Objektifiera-MashrekaBinte-Mannan");
                int result = fileChooser.showOpenDialog(frame);
                if (result == JFileChooser.APPROVE_OPTION) {
                    String filePath = fileChooser.getSelectedFile().getAbsolutePath();
                    //kan läsa json file data
                    List<DataObject> data = jsonFileReader.readJsonFile(filePath);
                    displayDataInTable(data);
                }
            }
        });

        JButton csvButton = new JButton("Read CSV File"); //Button för att ge action att läsa csv file
        csvButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //för att välja vilken file ska jag läsa
                JFileChooser fileChooser = new JFileChooser("/Users/MashrekasMac/Desktop/Avancerad-java-Objektifiera-MashrekaBinte-Mannan");
                int result = fileChooser.showOpenDialog(frame);
                if (result == JFileChooser.APPROVE_OPTION) {
                    String filePath = fileChooser.getSelectedFile().getAbsolutePath();
                    //kan läsa json file data
                    List<DataObject> data = csvFileReader.readCsvFile(filePath);
                    //visa json file data i table
                    displayDataInTable(data);
                }
            }
        });
        //GUI components
        tableModel = new DefaultTableModel();
        table = new JTable(tableModel);
        table.setRowHeight(20);
        table.setFont(new Font("Arial", Font.PLAIN, 13));
        JScrollPane scrollPane = new JScrollPane(table);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(jsonButton);
        buttonPanel.add(csvButton);

        frame.getContentPane().add(buttonPanel, BorderLayout.NORTH);
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    //presentera data i tabelen
    private void displayDataInTable(List<DataObject> data) {
        //set the number of rows in the model.
        //If the new size is greater than the current size ,new rows are added to the end of the model
        tableModel.setRowCount(0);
        //sets the number of columns in the model.
        //if the new size is greater than the current size,new columns are added to the end of the model with null cell values.
        tableModel.setColumnCount(0);

        if (data != null && !data.isEmpty()) {
            Object[] columnNames = data.get(0).getColumnNames(); //för att hitta 1st kolumn namn
            //Replaces the column identifiers in the model.
            //if the number of new identifiers is greater than the current number of columns ,new columns are added to the end of each row in the model.
            //if  the number of newIdentifiers  is less than the current number of columns, all the extra columns at the end of a row are discarded.
            tableModel.setColumnIdentifiers(columnNames);


            for (DataObject obj : data) {
                tableModel.addRow(obj.getDataAsArray());//lägga till rad data i tabelen


            }
        }
    }

    public static void main(String[] args) {

                new MainApp();
    }

}

