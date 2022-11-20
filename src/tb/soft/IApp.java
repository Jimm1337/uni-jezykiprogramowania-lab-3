package tb.soft;

public interface IApp extends Runnable {
    boolean handleLogin(String login, char[] password);
    boolean handleRegister(String login, char[] password);

    String getUsers();

    String readDatabase(String filename);
    void writeDatabase(String filename);
}
