package tb.soft.gui.swing;

import javax.swing.*;

class PopupRegisterSuccess extends PopupBase {
    public PopupRegisterSuccess(JFrame owner) {
        super(owner, true);
    }

    @Override
    protected String getPopupText() {
        return "Zarejestrowano pomyślnie!";
    }
}
