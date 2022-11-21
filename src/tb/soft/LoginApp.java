package tb.soft;

import tb.soft.db.UsersDb;
import tb.soft.gui.IGui;
import tb.soft.gui.swing.GuiManager;

public class LoginApp implements Runnable, IApp {
    private static final String DB_FILE = "db.txt";
    private final IGui gui;
    private final UsersDb db;
    private String currentUser;

    public LoginApp() {
        db = new UsersDb(DB_FILE);
        gui = new GuiManager(this);
    }

    @Override
    public void run() {
        gui.entry();
    }

    @Override
    public boolean handleLogin(String login, char[] password) {
        if (db.checkCredentials(login, password)) {
            currentUser = login;
            return true;
        }
        return false;
    }

    @Override
    public boolean handleRegister(String login, char[] password) {
        return db.addUser(login, password);
    }

    @Override
    public void handleRemove() {
        db.removeUser(currentUser);
        currentUser = null;
    }

    @Override
    public Object[][] readDatabase() {
        return db.toTable();
    }
}
