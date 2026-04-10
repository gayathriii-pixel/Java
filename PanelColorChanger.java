import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class PanelColorChanger extends JFrame {

    private final JPanel[] panels = new JPanel[5];
    private final String[] panelPositions = {BorderLayout.NORTH, BorderLayout.SOUTH, BorderLayout.EAST, BorderLayout.WEST, BorderLayout.CENTER};
    private final Random random = new Random();

    public PanelColorChanger() {
        setTitle("Panel Color Changer");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10)); // Add some spacing between panels

        // Create and add panels to the frame
        for (int i = 0; i < 5; i++) {
            panels[i] = new JPanel();
            panels[i].setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
            add(panels[i], panelPositions[i]);
        }

        // Use a Timer to change colors every 3 seconds
        Timer timer = new Timer(3000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (JPanel panel : panels) {
                    panel.setBackground(getRandomColor());
                }
            }
        });

        timer.start();
        setVisible(true);
    }

    private Color getRandomColor() {
        // Generate a random color using RGB values
        int red = random.nextInt(256);
        int green = random.nextInt(256);
        int blue = random.nextInt(256);
        return new Color(red, green, blue);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(PanelColorChanger::new);
    }
}