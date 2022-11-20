package tb.soft.gui.swing;

import java.awt.*;

public class PopupRegisterFailure extends PopupBase {
    public PopupRegisterFailure(Frame owner) {
        super(owner, false);
    }

    @Override
    protected String getPopupText() {
        return "Nie udało się zarejestrować!";
    }
}
