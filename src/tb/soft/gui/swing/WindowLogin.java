package tb.soft.gui.swing;

import tb.soft.gui.IGui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Arrays;

class WindowLogin extends WindowBase {
    private static final Dimension MIN_SIZE = new Dimension(300, 170);

    private final JTextField login;
    private final JPasswordField password;

    public WindowLogin(IGui manager) {
        super(manager, "Logowanie");

        login = new JTextField();
        password = new JPasswordField();

        JButton buttonLogin = new JButton("Zaloguj");
        buttonLogin.addActionListener(this::eventLogin);
        JButton buttonRegister = new JButton("Rejestracja");
        buttonRegister.addActionListener(this::eventRegister);
        JButton buttonQuit = new JButton("Wyjście");
        buttonQuit.addActionListener(this::eventQuit);

        content.addComponent(new JLabel("Login:"), 0, 0, 1, 1);
        content.addComponent(login, 1, 0, 1, 1);
        content.addComponent(new JLabel("Hasło:"), 0, 1, 1, 1);
        content.addComponent(password, 1, 1, 1, 1);
        content.addComponent(buttonLogin, 0, 2, 2, 1);
        content.addComponent(buttonRegister, 0, 3, 1, 1);
        content.addComponent(buttonQuit, 1, 3, 1, 1);
    }

    @Override
    protected void setSize() {
        setMinimumSize(MIN_SIZE);
    }

    private void eventLogin(ActionEvent e) {
        String username = login.getText();
        char[] pass = password.getPassword();

        if (username.isEmpty() || pass.length == 0) {
            content.setBackground(Color.RED);
            Arrays.fill(pass, (char)0);
            new PopupLoginFailure(this, "Wypełnij wszystkie pola!");
            content.setBackground(Color.WHITE);
        } else if (manager.getApp().handleLogin(username, pass)) {
            content.setBackground(Color.GREEN);
            Arrays.fill(pass, (char)0);
            new PopupLoginSuccess(this);
            manager.flow(new WindowUX(manager));
        } else {
            content.setBackground(Color.RED);
            Arrays.fill(pass, (char)0);
            new PopupLoginFailure(this);
            content.setBackground(Color.WHITE);
        }
    }

    private void eventRegister(ActionEvent event) {
        manager.flow(new WindowRegister(manager));
    }
}
