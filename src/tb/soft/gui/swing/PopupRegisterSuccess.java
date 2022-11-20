package tb.soft.gui.swing;

import java.awt.*;

class PopupRegisterSuccess extends PopupBase {
    public PopupRegisterSuccess(Frame owner) {
        super(owner, true);
    }

    @Override
    protected String getPopupText() {
        return "Zarejestrowano pomyślnie!";
    }
}
