package tb.soft.gui.swing;

import tb.soft.IApp;
import tb.soft.gui.IGui;
import tb.soft.gui.IWindow;

import java.awt.*;

public class GuiManager extends Container implements IGui {
    private WindowBase window;
    private final IApp app;

    public GuiManager(IApp app) {
        this.app = app;

        flow(new WindowLogin(this));
    }
    @Override
    public void entry() {
        window.setVisible(true);
    }

    @Override
    public IApp getApp() {
        return app;
    }

    @Override
    public void flow(IWindow window) {
        WindowBase wnd = (WindowBase)window;

        if (this.window != null) {
            this.window.setVisible(false);
            this.window.dispose();
        }

        this.window = wnd;
        this.window.setVisible(true);
    }
}
