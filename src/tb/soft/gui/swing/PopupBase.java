package tb.soft.gui.swing;

import javax.swing.*;
import java.awt.event.ActionEvent;

abstract class PopupBase extends JDialog {
    private static final String ICON_PATH_SUCCESS = "src/tb/soft/gui/swing/res/success.gif";
    private static final String ICON_PATH_FAILURE = "src/tb/soft/gui/swing/res/error.gif";
    private static final String BUTTON_TEXT = "OK";
    private static final String TITLE_SUCCESS = "Sukces!";
    private static final String TITLE_FAILURE = "Błąd!";

    protected PopupBase(JFrame owner, boolean success) {
        super(owner, success ? TITLE_SUCCESS : TITLE_FAILURE, true);

        Content content = new Content(this);

        JLabel text = new JLabel(getPopupText());
        content.addComponent(text, 0, 0, 1, 1);

        JButton button = new JButton(BUTTON_TEXT);
        button.addActionListener(PopupBase::okButtonHandler);
        content.addComponent(button, 0, 1, 1, 1);

        ImageIcon image = new ImageIcon(success ? ICON_PATH_SUCCESS : ICON_PATH_FAILURE);
        content.addComponent(new JLabel(image), 1, 0, 1, 2);

        setContentPane(content);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(owner);
    }

    protected abstract String getPopupText();

    private static void okButtonHandler(ActionEvent event) {
        JButton button = (JButton)event.getSource();
        JDialog dialog = (JDialog)SwingUtilities.getRoot(button);

        dialog.dispose();
    }
}
