package tb.soft.gui.swing;

import javax.swing.*;

class PopupLoginFailure extends PopupBase {
    private final String message;
    public PopupLoginFailure(JFrame owner) {
        super(owner, false);
        this.message = "Niepoprawny login lub hasło!";
    }

    public PopupLoginFailure(JFrame owner, String message) {
        super(owner, false);
        this.message = message;
    }

    @Override
    protected String getPopupText() {
        return message;
    }
}
