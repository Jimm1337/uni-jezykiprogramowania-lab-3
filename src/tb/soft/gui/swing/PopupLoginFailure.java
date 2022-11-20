package tb.soft.gui.swing;

import java.awt.*;

class PopupLoginFailure extends PopupBase {
    public PopupLoginFailure(Frame owner) {
        super(owner, false);
    }

    @Override
    protected String getPopupText() {
        return "Niepoprawny login lub hasło!";
    }
}
