package tb.soft.gui.swing;

import javax.swing.*;
import java.awt.*;

public class PopupRegisterFailure extends PopupBase {
    private static final Dimension MIN_SIZE = new Dimension(300, 125);

    public PopupRegisterFailure(JFrame owner, String message) {
        super(owner, message, false);
    }

    @Override
    protected void setSize() {
        setMinimumSize(MIN_SIZE);
    }
}
