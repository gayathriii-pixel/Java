import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RegistrationForm extends JFrame {
    private JTextField nameField, ageField, mailField, contactField;
    private JRadioButton maleButton, femaleButton;
    private JButton okButton, clearButton;
    private ButtonGroup genderGroup;

    public RegistrationForm() {
        setTitle("User Registration");
        setSize(350, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(7, 2, 5, 5));

        // Form fields
        add(new JLabel("Name:"));
        nameField = new JTextField();
        add(nameField);

        add(new JLabel("Age:"));
        ageField = new JTextField();
        add(ageField);

        add(new JLabel("Mail ID:"));
        mailField = new JTextField();
        add(mailField);

        add(new JLabel("Gender:"));
        JPanel genderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        maleButton = new JRadioButton("Male");
        femaleButton = new JRadioButton("Female");
        genderGroup = new ButtonGroup();
        genderGroup.add(maleButton);
        genderGroup.add(femaleButton);
        genderPanel.add(maleButton);
        genderPanel.add(femaleButton);
        add(genderPanel);

        add(new JLabel("Contact Number:"));
        contactField = new JTextField();
        add(contactField);

        // Buttons
        okButton = new JButton("OK");
        clearButton = new JButton("Clear");
        add(okButton);
        add(clearButton);

        // OK button action
        okButton.addActionListener(e -> {
            String name = nameField.getText().trim();
            String ageStr = ageField.getText().trim();
            String mail = mailField.getText().trim();
            String contact = contactField.getText().trim();
            String gender = maleButton.isSelected() ? "Male" : femaleButton.isSelected() ? "Female" : "";

            if (name.isEmpty() || ageStr.isEmpty() || mail.isEmpty() || gender.isEmpty() || contact.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill all fields!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int age;
            try {
                age = Integer.parseInt(ageStr);
                if (age <= 0 || age > 120) throw new NumberFormatException();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid age!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!mail.contains("@") || !mail.contains(".")) {
                JOptionPane.showMessageDialog(this, "Invalid email!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!contact.matches("\\d{10}")) {
                JOptionPane.showMessageDialog(this, "Invalid contact number!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Show details on next screen
            JFrame detailsFrame = new JFrame("User Details");
            detailsFrame.setSize(300, 200);
            detailsFrame.setLayout(new GridLayout(6, 1));
            detailsFrame.add(new JLabel("Name: " + name));
            detailsFrame.add(new JLabel("Age: " + age));
            detailsFrame.add(new JLabel("Mail ID: " + mail));
            detailsFrame.add(new JLabel("Gender: " + gender));
            detailsFrame.add(new JLabel("Contact: " + contact));
            detailsFrame.setVisible(true);
        });

        // Clear button action
        clearButton.addActionListener(e -> {
            nameField.setText("");
            ageField.setText("");
            mailField.setText("");
            contactField.setText("");
            genderGroup.clearSelection();
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(RegistrationForm::new);
    }
}
