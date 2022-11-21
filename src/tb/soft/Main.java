package tb.soft;

import javax.swing.*;

/**
 * klasa główna zawierająca metodę statyczną main
 */
public class Main {
    public static void main(String[] args) {
        try {
            SwingUtilities.invokeLater(() -> new LoginApp().run());
        } catch (Exception e) {
            System.err.println("Unhandled exception in main(): " + e.getMessage());
        }
    }
}
