package tb.soft.gui;

import tb.soft.IApp;

public interface IGui {
    void entry();
    IApp getApp();
    void flow(IWindow window);
}
