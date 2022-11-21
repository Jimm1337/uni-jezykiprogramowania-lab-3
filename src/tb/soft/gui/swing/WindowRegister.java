package tb.soft.gui.swing;

import tb.soft.gui.IGui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Arrays;

class WindowRegister extends WindowBase {
    private static final Dimension MIN_SIZE = new Dimension(300, 150);

    private final JTextField newLoginField;
    private final JPasswordField newPasswordField;
    private final JPasswordField newPasswordField2;

    public WindowRegister(IGui manager) {
        super(manager, "Rejestracja");

        newLoginField = new JTextField();
        newPasswordField = new JPasswordField();
        newPasswordField2 = new JPasswordField();

        JButton buttonRegister = new JButton("Zarejestruj");
        buttonRegister.addActionListener(this::eventRegister);
        JButton buttonQuit = new JButton("Wyjście");
        buttonQuit.addActionListener(this::eventQuit);

        content.addComponent(new JLabel("Nowy Login:"), 0, 0, 1, 1);
        content.addComponent(newLoginField, 1, 0, 1, 1);
        content.addComponent(new JLabel("Nowe Hasło:"), 0, 1, 1, 1);
        content.addComponent(newPasswordField, 1, 1, 1, 1);
        content.addComponent(new JLabel("Powtórz Hasło:"), 0, 2, 1, 1);
        content.addComponent(newPasswordField2, 1, 2, 1, 1);
        content.addComponent(buttonRegister, 0, 3, 2, 1);
        content.addComponent(buttonQuit, 0, 4, 2, 1);
    }

    @Override
    protected void setSize() {
        setMinimumSize(MIN_SIZE);
    }

    private void eventRegister(ActionEvent event) {
        String newLogin = newLoginField.getText();
        char[] newPass = newPasswordField.getPassword();
        char[] newPass2 = newPasswordField2.getPassword();

        if (newLogin.isEmpty() || newPass.length == 0 || newPass2.length == 0) {
            content.setBackground(Color.RED);
            Arrays.fill(newPass, (char)0);
            Arrays.fill(newPass2, (char)0);
            new PopupRegisterFailure(this, "Wypełnij wszystkie pola!");
            content.setBackground(Color.WHITE);
        } else if (!Arrays.equals(newPass, newPass2)) {
            content.setBackground(Color.RED);
            Arrays.fill(newPass, (char)0);
            Arrays.fill(newPass2, (char)0);
            new PopupRegisterFailure(this, "Hasła nie są identyczne!");
            content.setBackground(Color.WHITE);
        } else if (manager.getApp().handleRegister(newLogin, newPass)) {
            content.setBackground(Color.GREEN);
            Arrays.fill(newPass, (char)0);
            Arrays.fill(newPass2, (char)0);
            new PopupRegisterSuccess(this);
            manager.flow(new WindowLogin(manager));
        } else {
            content.setBackground(Color.RED);
            Arrays.fill(newPass, (char)0);
            Arrays.fill(newPass2, (char)0);
            new PopupRegisterFailure(this, "Użytkownik o takim loginie już istnieje!");
            manager.flow(new WindowLogin(manager));
        }
    }
}
