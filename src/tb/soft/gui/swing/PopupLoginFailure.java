package tb.soft.gui.swing;

import javax.swing.*;
import java.awt.*;

class PopupLoginFailure extends PopupBase {
    private static final Dimension MIN_SIZE = new Dimension(250, 125);

    public PopupLoginFailure(JFrame owner) {
        super(owner, "Niepoprawny login lub hasło!", false);
    }

    public PopupLoginFailure(JFrame owner, String message) {
        super(owner, message, false);
    }

    @Override
    protected void setSize() {
        setMinimumSize(MIN_SIZE);
    }
}
