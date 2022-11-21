package tb.soft.gui.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

abstract class PopupBase extends JDialog {
    private static final String ICON_PATH_SUCCESS = "src/tb/soft/gui/swing/res/success.gif";
    private static final String ICON_PATH_FAILURE = "src/tb/soft/gui/swing/res/error.gif";
    private static final String BUTTON_TEXT = "OK";
    private static final String TITLE_SUCCESS = "Sukces!";
    private static final String TITLE_FAILURE = "Błąd!";

    protected PopupBase(JFrame owner, String message, boolean success) {
        super(owner, success ? TITLE_SUCCESS : TITLE_FAILURE, true);

        Content content = new Content(this);

        JTextArea text = new JTextArea(message);
        text.setEditable(false);
        text.setLineWrap(true);
        text.setSelectionColor(Color.WHITE);

        JLabel image = new JLabel(new ImageIcon(success ? ICON_PATH_SUCCESS : ICON_PATH_FAILURE));

        JButton button = new JButton(BUTTON_TEXT);
        button.addActionListener(PopupBase::okButtonHandler);

        content.addComponent(text, 0, 0, 1, 1);
        content.addComponent(button, 0, 1, 1, 1);
        content.addComponent(image, 1, 0, 1, 2);


        setContentPane(content);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(owner);
        setSize();
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }

    protected abstract void setSize();

    private static void okButtonHandler(ActionEvent event) {
        JButton button = (JButton)event.getSource();
        JDialog dialog = (JDialog)SwingUtilities.getRoot(button);

        dialog.dispose();
    }
}
