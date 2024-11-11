import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.*;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;




public class VehicleRepairApp extends JFrame {
    private final JComboBox<String> locationComboBox;
    private final JTextField nameField, repairCostField, rateField;
    private final JTextArea reportArea;
    private final Technician technician;

    public VehicleRepairApp() {
        technician = new Technician();

        setTitle("Vehicle Repair Technician Report");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        //GUI
        JPanel inputPanel = new JPanel(new GridLayout(5, 2));
        locationComboBox = new JComboBox<>(new String[]{"", "Cape Town", "Durban", "Pretoria"});
        nameField = new JTextField();
        repairCostField = new JTextField();
        rateField = new JTextArea();
        reportArea = new JTextArea();


        inputPanel.add(new JLabel("Technician Location"));
        inputPanel.add(locationComboBox);
        inputPanel.add(new JLabel("Technician Name"));
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Repair Cost"));
        inputPanel.add(repairCostField);
        inputPanel.add(new JLabel("Technician Rate"));
        inputPanel.add(rateField);

        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(reportArea), BorderLayout.CENTER);

        //Menu system
        JMenuBar menuBar = new JMenuBar();
        JMenuBar fileMenu = new JMenuBar("File");
        JMenuBar toolsMenu = new JMenuBar("Tools");

        JMenuItem exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.addActionListener(e -> System.exit(0));
        fileMenu.add(exitMenuItem);

        JMenuItem processReportMenuItem = new JMenuItem("Process Report");
        processReportMenuItem.addActionListener(e -> processReport());
        toolsMenu.add(processReportMenuItem);

        JMenuItem clearMenuItem = new JMenuItem("Clear");
        clearMenuItem.addActionListener(e -> clearFields());
        toolsMenu.add(clearMenuItem);

        JMenuItem saveReportMenuItem = new JMenuItem("Save Report");
        saveReportMenuItem.addActionListener(e -> saveReport());
        toolsMenu.add(saveReportMenuItem);

        menuBar.add(fileMenu);
        menuBar.add(toolsMenu);
        setJMenuBar(menuBar);






    }

    private void processReport() {
        String location = (String) locationComboBox.getSelectedItem();
        String name = nameField.getText();
        String repairCostStr = repairCostField.getText();
        String rateStr = rateField.getText();

        Dataa data = new Dataa(location, name, repairCostStr, rateStr);
        if (technician.ValidateData(data)) {
            double repairCost = Double.parseDouble(repairCostStr);
            double rate = Double.parseDouble(rateStr);
            double pay = technician.CalculatePay(repairCostStr, rateStr);

            reportArea.setText("Technician Report/n");
            reportArea.append("Location: " + location + "/n");
            reportArea.append("Name: " + name + "/n");
            reportArea.append("Repair Cost: " + repairCost + "/n");
            reportArea.append("Rate: " + rate + "/n");
            reportArea.append("Calculated Pay: " + pay + "/n");
        } else {
            JOptionPane.showMessageDialog(this, "Invalid data");
        }
    }


    private void clearFields(){
        locationComboBox.setSelectedIndex(0);
        nameField.setText("");
        repairCostField.setText("");
        rateField.setText("");
        reportArea.setText("");


    }


    private void saveReport() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(new FileWriter("report.txt"))) {
            writer.write(reportArea.getText());
            JOptionPane.showMessageDialog(this,"Report saved to report.txt");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, error saving);

        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VehicleRepairApp app = new VehicleRepairApp();
            app.setVisible(true);
        }};


}