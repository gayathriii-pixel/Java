import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ImageClickFrame extends JFrame {
    private int clickCount = 0;
    private JTextField clickField;
    private JButton clickButton;
    private JLabel imageLabel;
    private ImageIcon originalIcon;
    private ImageIcon enlargedIcon;

    public ImageClickFrame() {
        setTitle("Click Counter with Image Zoom");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Text field to show click count
        clickField = new JTextField("Clicks: 0", 15);
        clickField.setEditable(false);
        add(clickField);

        // Button to count clicks
        clickButton = new JButton("Click Me");
        add(clickButton);

        // Load image
        originalIcon = new ImageIcon("panel.png"); // Replace with your image path
        Image originalImage = originalIcon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        originalIcon = new ImageIcon(originalImage);

        Image enlargedImage = originalIcon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        enlargedIcon = new ImageIcon(enlargedImage);

        imageLabel = new JLabel(originalIcon);
        add(imageLabel);

        // Button click listener
        clickButton.addActionListener(e -> {
            clickCount++;
            clickField.setText("Clicks: " + clickCount);
        });

        // Mouse listeners for image zoom
        imageLabel.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                imageLabel.setIcon(enlargedIcon);
            }

            public void mouseExited(MouseEvent e) {
                imageLabel.setIcon(originalIcon);
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ImageClickFrame::new);
    }
}
