package tb.soft;

import tb.soft.gui.IGui;
import tb.soft.gui.swing.GuiManager;

public class LoginApp implements Runnable, IApp {
    private final IGui GUI = new GuiManager(this);

    @Override
    public void run() {
        GUI.entry();
    }

    @Override
    public boolean handleLogin(String login, char[] password) {
        //todo
        return false;
    }

    @Override
    public boolean handleRegister(String login, char[] password) {
        //todo
        return false;
    }

    @Override
    public String getUsers() {
        //todo
        return null;
    }

    @Override
    public String readDatabase(String filename) {
        //todo
        return null;
    }

    @Override
    public void writeDatabase(String filename) {
        //todo
    }
}
