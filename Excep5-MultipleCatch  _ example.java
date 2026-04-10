import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SmartCityFrame extends JFrame {

    // Main components
    private JComboBox<String> startLocation;
    private JComboBox<String> destinationLocation;
    private JButton findRouteButton;
    private JTextArea outputArea;
    private JPanel mapPanel;
    private JCheckBox trafficOverlayCheckbox;

    public SmartCityFrame() {
        // 1. Configure the Main Frame (JFrame)
        super("Smart City Navigator & Traffic Awareness 🚦");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 700);
        setLayout(new BorderLayout()); // Use BorderLayout for main structure

        // 2. Create and Add Panels
        
        // Input/Control Panel (North)
        JPanel controlPanel = createControlPanel();
        add(controlPanel, BorderLayout.NORTH);

        // Map/Visualization Panel (Center)
        mapPanel = new JPanel();
        mapPanel.setBackground(new Color(200, 220, 255)); // Light Blue/Map Placeholder
        mapPanel.setBorder(BorderFactory.createTitledBorder("Map View / Route Visualization "));
        // A real application would embed a map component here (e.g., using a library or a custom graphics component)
        add(mapPanel, BorderLayout.CENTER);

        // Output/Status Panel (South)
        JPanel statusPanel = createStatusPanel();
        add(statusPanel, BorderLayout.SOUTH);
        
        // 3. Finalize and Display
        setLocationRelativeTo(null); // Center the frame
        setVisible(true);
    }

    // --- Panel Creation Methods ---

    private JPanel createControlPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10)); // Simple layout for controls
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Sample Data for Dropdowns
        String[] places = {"Home", "Work", "Park Ave", "Central Plaza", "Hospital"};
        
        // Start Location
        panel.add(new JLabel("Start:"));
        startLocation = new JComboBox<>(places);
        panel.add(startLocation);
        
        // Destination Location
        panel.add(new JLabel("Destination:"));
        destinationLocation = new JComboBox<>(places);
        panel.add(destinationLocation);
        
        // Find Route Button
        findRouteButton = new JButton("Find Shortest Route 🗺️");
        findRouteButton.addActionListener(new FindRouteListener());
        panel.add(findRouteButton);

        // Traffic Awareness Checkbox
        trafficOverlayCheckbox = new JCheckBox("Show Live Traffic 🚥");
        trafficOverlayCheckbox.setSelected(true);
        panel.add(trafficOverlayCheckbox);
        
        return panel;
    }

    private JPanel createStatusPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Route Details & Traffic Alerts"));

        outputArea = new JTextArea(5, 80);
        outputArea.setEditable(false);
        outputArea.setText("Welcome to Smart City Navigator. Select your locations and click 'Find Route'.\n");
        
        JScrollPane scrollPane = new JScrollPane(outputArea);
        panel.add(scrollPane, BorderLayout.CENTER);

        return panel;
    }

    // --- Event Handling (Conceptual) ---

    private class FindRouteListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String start = (String) startLocation.getSelectedItem();
            String dest = (String) destinationLocation.getSelectedItem();
            boolean showTraffic = trafficOverlayCheckbox.isSelected();

            outputArea.append("\nCalculating route from **" + start + "** to **" + dest + "**...");

            // **TODO:** In a real application, this is where the core logic would go:
            // 1. Call a shortest path algorithm (e.g., Dijkstra's or A*)
            // 2. Query a traffic data model (if showTraffic is true)
            // 3. Update the mapPanel with the new route
            
            // Dummy Output
            outputArea.append("\n Route found: Via [Main St -> Bridge Rd]. Distance: 5.2 km.");
            if (showTraffic) {
                 outputArea.append("\n **Traffic Alert:** Heavy congestion on Bridge Rd. Recommended alternate: River Bypass.");
            } else {
                 outputArea.append("\nTraffic awareness is disabled.");
            }
        }
    }

    // --- Main Method to Run the Application ---

    public static void main(String[] args) {
        // Ensure GUI updates are done on the Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(SmartCityFrame::new);
    }
}
