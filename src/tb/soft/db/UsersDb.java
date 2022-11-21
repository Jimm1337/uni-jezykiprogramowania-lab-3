package tb.soft.db;

import java.io.*;
import java.util.*;

public class UsersDb {
    private Map<String, char[]> users;
    private final String filename;

    public UsersDb(String dbFile) {
        filename = dbFile;
        read();
    }

    public boolean addUser(String login, char[] password) {
        if (checkLogin(login)) {
            return false;
        }
        users.put(login, password.clone());
        write();
        return true;
    }

    public void removeUser(String login) {
        users.remove(login);
        write();
    }

    public boolean checkCredentials(String login, char[] password) {
        if (!checkLogin(login)) {
            return false;
        }
        return Arrays.equals(users.get(login), password);
    }

    public boolean checkLogin(String login) {
        return users.containsKey(login);
    }

    public void write() {
        try {
            FileOutputStream outStream = new FileOutputStream(filename);
            ObjectOutputStream objOutStream = new ObjectOutputStream(outStream);

            objOutStream.writeObject(users);

            objOutStream.close();
            outStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void read() {
        try {
            FileInputStream inStream;
            try {
                inStream = new FileInputStream(filename);
            } catch (FileNotFoundException e) {
                users = new HashMap<>();
                return;
            }


            ObjectInputStream objInStream = new ObjectInputStream(inStream);

            cleanup();
            users = (HashMap<String, char[]>) objInStream.readObject();
            if (users == null) users = new HashMap<>();

            objInStream.close();
            inStream.close();
        } catch (IOException | ClassNotFoundException | ClassCastException e) {
            System.err.println("Błąd odczytu bazy danych!");
            e.printStackTrace();
        }
    }

    private void cleanup() {
        if (users != null) {
            for (var record : users.entrySet()) {
                Arrays.fill(record.getValue(), (char) 0);
            }
        }

    }

    public Object[][] toTable() {
        Object[][] ret = new Object[users.size()][2];
        int i = 0;
        for (var record : users.entrySet()) {
            ret[i][0] = record.getKey();
            ret[i][1] = record.getValue();
            i++;
        }
        return ret;
    }
}
