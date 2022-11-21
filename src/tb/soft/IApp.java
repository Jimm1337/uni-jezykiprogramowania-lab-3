package tb.soft;

public interface IApp extends Runnable {
    boolean handleLogin(String login, char[] password);
    boolean handleRegister(String login, char[] password);
    void handleRemove();
    Object[][] readDatabase();
}
