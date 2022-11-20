package tb.soft.gui.swing;

import javax.swing.*;

public class PopupRegisterFailure extends PopupBase {
    private final String message;
    public PopupRegisterFailure(JFrame owner) {
        super(owner, false);
        this.message = "Nie udało się zarejestrować!";
    }

    public PopupRegisterFailure(JFrame owner, String message) {
        super(owner, false);
        this.message = message;
    }

    @Override
    protected String getPopupText() {
        return message;
    }
}
