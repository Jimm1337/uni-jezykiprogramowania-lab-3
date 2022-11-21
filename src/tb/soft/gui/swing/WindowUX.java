package tb.soft.gui.swing;

import tb.soft.gui.IGui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Arrays;

class WindowUX extends WindowBase {
    private static final Dimension MIN_SIZE = new Dimension(400, 300);

    private static final String[] COLUMNS = {"Login", "Hasło"};
    Object[][] data;

    public WindowUX(IGui manager) {
        super(manager, "Użytkownicy");

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu menu = new JMenu("Konto");
        menuBar.add(menu);

        JMenuItem logoutItem = new JMenuItem("Wyloguj");
        logoutItem.addActionListener(this::eventLogout);
        menu.add(logoutItem);

        JMenuItem deleteItem = new JMenuItem("Usuń konto");
        deleteItem.addActionListener(this::eventDelete);
        menu.add(deleteItem);

        Object[][] data = manager.getApp().readDatabase();
        DefaultTableModel model = new DefaultTableModel(data, COLUMNS) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };


        JScrollPane scrollPane = new JScrollPane(new JTable(model));

        JButton buttonQuit = new JButton("Wyjście");
        buttonQuit.addActionListener(this::eventQuit);

        content.addComponent(scrollPane, 0, 0, 1, 1);
        content.addComponent(buttonQuit, 0, 1, 1, 1);
    }

    @Override
    protected void setSize() {
        setMinimumSize(MIN_SIZE);
    }

    private void cleanup() {
        if (data != null) {
            Arrays.stream(data).forEach(pass -> Arrays.fill(pass, 0));
            data = null;
        }

    }

    private void eventLogout(ActionEvent event) {
        cleanup();
        manager.flow(new WindowLogin(manager));
    }

    private void eventDelete(ActionEvent event) {
        cleanup();
        manager.getApp().handleRemove();
        manager.flow(new WindowLogin(manager));
    }

    @Override
    protected void eventQuit(ActionEvent event) {
        cleanup();
        super.eventQuit(event);
    }
}
