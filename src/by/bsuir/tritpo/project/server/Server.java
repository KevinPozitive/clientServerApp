package by.bsuir.tritpo.project.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;

public class Server {
    private static final int PORT = 6666;
    protected static LinkedList<ServerSomething> serverList = new LinkedList<>(); // список всех нитей - экземпляров
    protected LinkedList<String> names = new LinkedList<>();
////////////////////////
    public void setNames(String name) {
        this.names.add(name);
    }
    public static LinkedList<ServerSomething> getServerList() {
        return serverList;
    }
/////////////////
    // сервера, слушающих каждый своего клиента
    protected static Story story; // история переписки
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        story = new Story();
        System.out.println("Server Started");
        try {
            while (true) {
                // Блокируется до возникновения нового соединения:
                Socket socket = server.accept();
                try {
                    serverList.add(new ServerSomething(socket)); // добавить новое соединенние в список
                } catch (IOException e) {
                    // Если завершится неудачей, закрывается сокет,
                    // в противном случае, нить закроет его:
                    socket.close();
                }
            }
        } finally {
            server.close();
        }
    }
}