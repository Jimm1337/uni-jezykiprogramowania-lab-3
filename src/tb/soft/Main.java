package tb.soft;

import javax.swing.*;

/**
 * klasa główna zawierająca metodę statyczną main
 */
public class Main {
    public static void main(String[] args) {
        try {
            LoginApp loginApp = new LoginApp();
            SwingUtilities.invokeLater(loginApp);
        } catch (Exception e) {
            System.err.println("Unhandled exception in main(): " + e.getMessage());
        }
    }
}
