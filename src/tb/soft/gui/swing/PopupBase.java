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
    private static final Insets GAPS = new Insets(10, 10, 10, 10);

    protected PopupBase(Frame owner, boolean success) {
        super(owner, success ? TITLE_SUCCESS : TITLE_FAILURE, true);

        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = GAPS;

        JPanel panel = new JPanel(layout);

        JLabel label = new JLabel(getPopupText());
        panel.add(label, constraints);

        JButton button = new JButton(BUTTON_TEXT);
        button.addActionListener(PopupBase::okButtonHandler);
        constraints.gridy = 1;
        panel.add(button, constraints);

        ImageIcon image = new ImageIcon(success ? ICON_PATH_SUCCESS : ICON_PATH_FAILURE);
        JLabel imageLabel = new JLabel(image);
        constraints.gridy = 0;
        constraints.gridx = 1;
        constraints.gridheight = 2;
        panel.add(imageLabel, constraints);

        setContentPane(panel);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(owner);
    }

    protected abstract String getPopupText();

    private static void okButtonHandler(ActionEvent event) {
        JButton button = (JButton)event.getSource();
        JPanel panel = (JPanel)button.getParent();
        JDialog dialog = (JDialog)panel.getTopLevelAncestor();

        dialog.dispose();
    }
}
