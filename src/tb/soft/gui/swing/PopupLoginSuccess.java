package tb.soft.gui.swing;

import java.awt.*;

class PopupLoginSuccess extends PopupBase {
    public PopupLoginSuccess(Frame owner) {
        super(owner, true);
    }
    @Override
    protected String getPopupText() {
        return "Zalogowano pomyślnie!";
    }
}
