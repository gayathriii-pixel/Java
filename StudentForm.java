import javax.swing.*;
import java.awt.*;
import javax.swing.border.TitledBorder;

public class StudentForm extends JFrame {

    public StudentForm() {
		 JButton b1;
        setTitle("Student Registration Form");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Add padding
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Spacing between components
        gbc.anchor = GridBagConstraints.WEST; // Align components to the left

        // --- Full Name Section ---
        gbc.gridx = 0;
        gbc.gridy = 0;
        mainPanel.add(new JLabel("Full Name"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        mainPanel.add(new JTextField(15), gbc);
        mainPanel.add(new JLabel("First Name"), gbc);

        gbc.gridx = 2;
        gbc.gridy = 0;
        mainPanel.add(new JTextField(15), gbc);
        mainPanel.add(new JLabel("Last Name"), gbc);
        
        // --- Address Section ---
        gbc.gridx = 0;
        gbc.gridy = 1;
        mainPanel.add(new JLabel("Address"), gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 2; // Span across two columns
        mainPanel.add(new JTextField(40), gbc);
        mainPanel.add(new JLabel("Street Address"), gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        mainPanel.add(new JTextField(15), gbc);
        mainPanel.add(new JLabel("City"), gbc);

        gbc.gridx = 2;
        gbc.gridy = 2;
        mainPanel.add(new JTextField(15), gbc);
        mainPanel.add(new JLabel("State/Province"), gbc);
        
        // --- Birth Date Section ---
        gbc.gridx = 0;
        gbc.gridy = 3;
        mainPanel.add(new JLabel("Birth Date"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        mainPanel.add(new JTextField(5), gbc);
        mainPanel.add(new JLabel("Month"), gbc);

        gbc.gridx = 2;
        gbc.gridy = 3;
        mainPanel.add(new JTextField(5), gbc);
        mainPanel.add(new JLabel("Day"), gbc);

        gbc.gridx = 3;
        gbc.gridy = 3;
        mainPanel.add(new JTextField(5), gbc);
        mainPanel.add(new JLabel("Year"), gbc);

        // --- Gender Section ---
        gbc.gridx = 0;
        gbc.gridy = 4;
        mainPanel.add(new JLabel("Gender"), gbc);

        JPanel genderPanel = new JPanel();
        JRadioButton male = new JRadioButton("Male");
        JRadioButton female = new JRadioButton("Female");
        JRadioButton na = new JRadioButton("N/A");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        genderGroup.add(na);
        genderPanel.add(male);
        genderPanel.add(female);
        genderPanel.add(na);
        
        gbc.gridx = 1;
        gbc.gridy = 4;
        mainPanel.add(genderPanel, gbc);

        // --- Other Fields ---
        gbc.gridx = 0;
        gbc.gridy = 5;
        mainPanel.add(new JLabel("Student Number"), gbc);
		  
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.gridwidth = 3;
        mainPanel.add(new JTextField(25), gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        mainPanel.add(new JLabel("Student Email"), gbc);
        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.gridwidth = 3;
        mainPanel.add(new JTextField(25), gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 7;
        mainPanel.add(new JLabel("Company"), gbc);
        gbc.gridx = 1;
        gbc.gridy = 7;
        gbc.gridwidth = 3;
        mainPanel.add(new JTextField(25), gbc);
        
        // --- Courses Section ---
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 1;
        mainPanel.add(new JLabel("Courses"), gbc);
        
        JPanel coursesPanel = new JPanel(new GridLayout(3, 3, 10, 5)); // 3 rows, 3 columns
        coursesPanel.add(new JCheckBox("English 101"));
        coursesPanel.add(new JCheckBox("English 102"));
        coursesPanel.add(new JCheckBox("Creative Writing 1"));
        coursesPanel.add(new JCheckBox("Creative Writing 2"));
        coursesPanel.add(new JCheckBox("History 101"));
        coursesPanel.add(new JCheckBox("History 102"));
        coursesPanel.add(new JCheckBox("Math 101"));
        coursesPanel.add(new JCheckBox("Math 102"));
        coursesPanel.add(new JCheckBox("Windows 8"));

        gbc.gridx = 1;
        gbc.gridy = 8;
        gbc.gridwidth = 3;
        mainPanel.add(coursesPanel, gbc);
        
        // --- Additional Comments Section ---
        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.gridwidth = 1;
        mainPanel.add(new JLabel("Additional Comments"), gbc);

        JTextArea commentsArea = new JTextArea(4, 30);
        JScrollPane scrollPane = new JScrollPane(commentsArea);
        gbc.gridx = 1;
        gbc.gridy = 9;
        gbc.gridwidth = 3;
        mainPanel.add(scrollPane, gbc);

        // --- Date Section ---
        JPanel datePanel = new JPanel();
        datePanel.setBorder(BorderFactory.createTitledBorder("Date"));
        datePanel.add(new JTextField(15));
        
        gbc.gridx = 0;
        gbc.gridy = 10;
        gbc.gridwidth = 4;
        gbc.anchor = GridBagConstraints.EAST;
        mainPanel.add(datePanel, gbc);
		  
		  gbc.gridx=0;
		  gbc.gridy=11;
		  gbc.gridwidth=1;
		  mainPanel.add(new JLabel("Submit"),gbc);
		  
		  gbc.gridx=1;
		  gbc.gridy=11;
		  gbc.gridwidth=1;
		  b1=new JButton("Submit");
		  mainPanel.add(b1,gbc);
        
        add(mainPanel);
        pack(); // Adjust frame size to fit all components
        setLocationRelativeTo(null); // Center the frame
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new StudentForm().setVisible(true);
        });
    }
}