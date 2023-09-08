import javax.swing.*;
import java.awt.event.*;
import java.util.Map;

public class CurrencyConverterApp extends JFrame {
    private Map<String, Double> exchangeRates; // Simulated exchange rates

    private JComboBox<String> baseCurrencyComboBox;
    private JComboBox<String> targetCurrencyComboBox;
    private JTextField amountTextField;
    private JLabel resultLabel;

    public CurrencyConverterApp() {
        setTitle("Currency Converter");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Simulated exchange rates (Replace with actual API call)
        exchangeRates = Map.of("USD", 1.0, "EUR", 0.85, "JPY", 109.35);

        baseCurrencyComboBox = new JComboBox<>(exchangeRates.keySet().toArray(new String[0]));
        targetCurrencyComboBox = new JComboBox<>(exchangeRates.keySet().toArray(new String[0]));
        amountTextField = new JTextField(10);
        JButton convertButton = new JButton("Convert");
        resultLabel = new JLabel();

        convertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String baseCurrency = (String) baseCurrencyComboBox.getSelectedItem();
                String targetCurrency = (String) targetCurrencyComboBox.getSelectedItem();
                double amount = Double.parseDouble(amountTextField.getText());

                double baseRate = exchangeRates.get(baseCurrency);
                double targetRate = exchangeRates.get(targetCurrency);

                double convertedAmount = amount * (targetRate / baseRate);

                resultLabel.setText(String.format("%.2f %s is equal to %.2f %s",
                        amount, baseCurrency, convertedAmount, targetCurrency));
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Base Currency:"));
        panel.add(baseCurrencyComboBox);
        panel.add(new JLabel("Target Currency:"));
        panel.add(targetCurrencyComboBox);
        panel.add(new JLabel("Amount:"));
        panel.add(amountTextField);
        panel.add(convertButton);
        panel.add(resultLabel);

        add(panel);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CurrencyConverterApp();
            }
        });
    }
}