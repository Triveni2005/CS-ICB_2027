import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DigitalClock extends JFrame {

    // Label to display time
    private JLabel timeLabel;

    // Constructor to set up the frame and components
    public DigitalClock() {
        // Set up the frame
        setTitle("Digital Clock");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Set up the label
        timeLabel = new JLabel("", SwingConstants.CENTER);
        timeLabel.setFont(new Font("Arial", Font.PLAIN, 48)); // Set the font size for the time display
        
        // Set up the layout
        setLayout(new BorderLayout());
        add(timeLabel, BorderLayout.CENTER);
        
        // Start the clock
        startClock();
    }

    // Method to update the clock every second
    private void startClock() {
        Timer timer = new Timer(1000, e -> {
            // Get current time
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            String time = sdf.format(new Date());
            timeLabel.setText(time);  // Update the time on the label
        });
        timer.start();
    }

    // Main method to run the clock application
    public static void main(String[] args) {
        // Run the clock on the Event Dispatch Thread (Swing best practice)
        SwingUtilities.invokeLater(() -> {
            DigitalClock clock = new DigitalClock();
            clock.setVisible(true);  // Show the frame
        });
    }
}
