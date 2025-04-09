   // Import necessary packages for Swing GUI components and AWT for layout management
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Define a class for the currency converter application
public class SimpleCurrencyConverter extends JFrame {

    // Declare fields for GUI components
    private JTextField amountField; // Field to input the amount to convert
    private JComboBox<String> fromCurrencyComboBox; // Combo box to select the source currency
    private JComboBox<String> toCurrencyComboBox; // Combo box to select the target currency
    private JTextField resultField; // Field to display the conversion result

    // Define exchange rates relative to USD (base currency)
    private final double[] EXCHANGE_RATES = {
        1.0, // USD (base currency)
        0.88, // EUR
        0.76, // GBP
        109.45, // JPY
        1.31 // CAD
    };

    // Constructor to initialize the GUI components
    public SimpleCurrencyConverter() {
        // Set the title of the application window
        super("Currency Converter");

        // Set the layout manager for the frame
        setLayout(new BorderLayout());

        // Create a panel for input fields
        JPanel inputPanel = new JPanel();
        // Add a label for the amount field
        inputPanel.add(new JLabel("Amount:"));
        // Create a text field to input the amount
        amountField = new JTextField(10);
        // Add the amount field to the input panel
        inputPanel.add(amountField);

        // Add the input panel to the north part of the frame
        add(inputPanel, BorderLayout.NORTH);

        // Create a panel for conversion options
        JPanel conversionPanel = new JPanel();
        // Define an array of currency options
        String[] currencies = {"USD", "EUR", "GBP", "JPY", "CAD"};
        // Create a combo box to select the source currency
        fromCurrencyComboBox = new JComboBox<>(currencies);
        // Create a combo box to select the target currency
        toCurrencyComboBox = new JComboBox<>(currencies);

        // Add labels and combo boxes for source and target currencies
        conversionPanel.add(new JLabel("From:"));
        conversionPanel.add(fromCurrencyComboBox);
        conversionPanel.add(new JLabel("To:"));
        conversionPanel.add(toCurrencyComboBox);

        // Create a button to trigger the conversion
        JButton convertButton = new JButton("Convert");
        // Add an action listener to the button to handle clicks
        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Try to parse the amount and perform the conversion
                try {
                    // Parse the amount from the text field
                    double amount = Double.parseDouble(amountField.getText());
                    // Get the indices of the selected currencies
                    int fromIndex = fromCurrencyComboBox.getSelectedIndex();
                    int toIndex = toCurrencyComboBox.getSelectedIndex();

                    // Perform the currency conversion
                    double result = convertCurrency(amount, fromIndex, toIndex);
                    // Display the result in the result field
                    resultField.setText(String.format("%.2f", result));
                } catch (NumberFormatException ex) {
                    // Handle invalid input by showing an error message
                    JOptionPane.showMessageDialog(SimpleCurrencyConverter.this, "Invalid amount", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

            // Method to perform the currency conversion
            private double convertCurrency(double amount, int fromIndex, int toIndex) {
                // Convert the amount to the base currency (USD) first
                double baseAmount = amount / EXCHANGE_RATES[fromIndex];
                // Then convert to the target currency
                return baseAmount * EXCHANGE_RATES[toIndex];
            }
        });
        // Add the convert button to the conversion panel
        conversionPanel.add(convertButton);

        // Add the conversion panel to the center part of the frame
        add(conversionPanel, BorderLayout.CENTER);

        // Create a panel for displaying the conversion result
        JPanel outputPanel = new JPanel();
        // Add a label for the result field
        outputPanel.add(new JLabel("Result:"));
        // Create a text field to display the result (non-editable)
        resultField = new JTextField(10);
        resultField.setEditable(false); // Make the result field non-editable
        // Add the result field to the output panel
        outputPanel.add(resultField);

        // Add the output panel to the south part of the frame
        add(outputPanel, BorderLayout.SOUTH);

        // Set the size of the application window
        setSize(400, 150);
        // Set the default close operation to exit the application when the window is closed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Make the application window visible
        setVisible(true);
    }

    // Main method to start the application
    public static void main(String[] args) {
        // Use SwingUtilities.invokeLater to ensure the GUI is created on the Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(SimpleCurrencyConverter::new);
    }
}
