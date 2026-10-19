package master;

import java.io.PrintWriter;
import java.net.Socket;

public class NetworkClient {
    public static void sendCommand(String ip, int port, String commandText) {
        System.out.println("[📡] Подключение к ноуту " + ip + ":" + port + "...");
        try (Socket socket = new Socket(ip, port);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {
            
            System.out.println("[🚀] Отправка команды: " + commandText);
            out.println(commandText);
            System.out.println("[✅] Успешно отправлено!");
            
        } catch (Exception e) {
            System.err.println("[❌] Ошибка подключения: " + e.getMessage());
        }
    }
}
