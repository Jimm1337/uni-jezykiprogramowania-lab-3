package tb.soft.gui.swing;

import javax.swing.*;

class PopupLoginSuccess extends PopupBase {
    public PopupLoginSuccess(JFrame owner) {
        super(owner, true);
    }
    @Override
    protected String getPopupText() {
        return "Zalogowano pomyślnie!";
    }
}
