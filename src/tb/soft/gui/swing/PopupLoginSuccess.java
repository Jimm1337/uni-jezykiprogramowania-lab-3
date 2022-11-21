package tb.soft.gui.swing;

import javax.swing.*;
import java.awt.*;

class PopupLoginSuccess extends PopupBase {
    private static final Dimension MIN_SIZE = new Dimension(230, 125);

    public PopupLoginSuccess(JFrame owner) {
        super(owner, "Zalogowano pomyślnie!", true);
    }

    @Override
    protected void setSize() {
        setMinimumSize(MIN_SIZE);
    }
}
