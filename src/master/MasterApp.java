package master;

import java.util.Scanner;

public class MasterApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== HACKER-NET: ПУЛЬТ УПРАВЛЕНИЯ ===");
        
        System.out.print("Введите IP-адрес ноутбука (например, 192.168.1.50): ");
        String ip = scanner.nextLine();
        int port = 8888;

        System.out.println("\nДоступные макросы:");
        System.out.println("1. matrix  - Запустить хакерский экран на ноуте");
        System.out.println("2. voice   - Заставить ноут говорить голосом");
        System.out.println("3. clear   - Очистить экран ноута");
        
        while (true) {
            System.out.print("\nВведи команду для ноута (или 'exit'): ");
            String input = scanner.nextLine();
            
            if ("exit".equalsIgnoreCase(input)) break;
            
            NetworkClient.sendCommand(ip, port, input);
        }
        scanner.close();
    }
}
