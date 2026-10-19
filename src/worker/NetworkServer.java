package worker;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class NetworkServer {
    private final int port;

    public NetworkServer(int port) {
        this.port = port;
    }

    public void start() {
        TerminalUI.logInfo("Сервер Воркера запущен на порту " + port + ". Ожидаю ПК...");
        
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                // Ждем подключения от ПК (блокирующий вызов)
                try (Socket clientSocket = serverSocket.accept();
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
                    
                    String receivedCommand = in.readLine();
                    if (receivedCommand != null) {
                        TerminalUI.logInfo("Получена команда от ПК: -> " + receivedCommand);
                        // Передаем команду на выполнение
                        CommandExecutor.execute(receivedCommand);
                    }
                } catch (Exception e) {
                    TerminalUI.logError("Ошибка при обработке пакета: " + e.getMessage());
                }
            }
        } catch (Exception e) {
            TerminalUI.logError("Не удалось запустить сервер: " + e.getMessage());
        }
    }
}
