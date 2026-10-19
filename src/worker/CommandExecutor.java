package worker;

public class CommandExecutor {
    public static void execute(String command) {
        switch (command.toLowerCase().trim()) {
            case "matrix":
                TerminalUI.printMatrixWelcome();
                // Используем встроенный синтезатор речи Linux (spd-say или espeak)
                runSystemCommand("spd-say 'Warning. System override detected.'");
                break;
                
            case "voice":
                TerminalUI.logInfo("Воркер начинает говорить...");
                runSystemCommand("spd-say 'Hello Master. I am listening to your commands.'");
                break;
                
            case "clear":
                TerminalUI.clear();
                System.out.println("Экран очищен. Ожидание...");
                break;
                
            default:
                TerminalUI.logError("Неизвестная команда: " + command);
                break;
        }
    }

    private static void runSystemCommand(String linuxCommand) {
        try {
            // Взрослая работа с процессами ОС Linux через Java!
            ProcessBuilder pb = new ProcessBuilder("bash", "-c", linuxCommand);
            pb.start();
        } catch (Exception e) {
            TerminalUI.logError("Не удалось выполнить системную команду: " + e.getMessage());
        }
    }
}
