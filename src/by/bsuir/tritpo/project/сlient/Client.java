package by.bsuir.tritpo.project.сlient;

public class Client {
    protected static String ipAddr = "localhost";
    protected static int port = 6666;
    /*
     * создание клиент-соединения с узананными адресом и номером порта
     * @param args
     */
    public static void main(String[] args) {
        new ClientSomething(ipAddr, port);
    }
}