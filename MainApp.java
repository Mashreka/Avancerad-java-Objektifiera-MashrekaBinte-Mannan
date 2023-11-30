import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

    private void displayDataInTable(List<DataObject> data) {
        tableModel.setRowCount(0);
        tableModel.setColumnCount(0);

        if (data != null && !data.isEmpty()) {
            Object[] columnNames = data.get(0).getColumnNames();
            tableModel.setColumnIdentifiers(columnNames);

            for (DataObject obj : data) {
                tableModel.addRow(obj.getDataAsArray());
            }
        }
    }

    public static void main(String[] args) {

                new MainApp();
    }

}

