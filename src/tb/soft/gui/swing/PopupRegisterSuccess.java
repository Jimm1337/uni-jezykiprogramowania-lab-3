package tb.soft.gui.swing;

import javax.swing.*;
import java.awt.*;

class PopupRegisterSuccess extends PopupBase {
    private static final Dimension MIN_SIZE = new Dimension(250, 125);

    public PopupRegisterSuccess(JFrame owner) {
        super(owner, "Zarejestrowano pomyślnie!", true);
    }

    @Override
    protected void setSize() {
        setMinimumSize(MIN_SIZE);
    }
}
