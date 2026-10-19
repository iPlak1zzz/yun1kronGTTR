package worker;

public class TerminalUI {
    // ANSI коды для управления цветом терминала Linux
    private static final String RESET = "\u001B[0m";
    private static final String GREEN = "\u001B[32m";
    private static final String RED = "\u001B[31m";
    private static final String CLEAR_SCREEN = "\033[H\033[2J";

    public static void clear() {
        System.out.print(CLEAR_SCREEN);
        System.out.flush();
    }

    public static void printMatrixWelcome() {
        clear();
        System.out.println(GREEN + "========================================");
        System.out.println("      ⚠️ SYSTEM OVERRIDE DETECTED ⚠️");
        System.out.println("========================================");
        System.out.println("  Initializing core protocols...");
        System.out.println("  Connection stable. Waiting for Master...");
        System.out.println("========================================" + RESET);
    }

    public static void logInfo(String message) {
        System.out.println(GREEN + "[INFO] " + message + RESET);
    }

    public static void logError(String message) {
        System.out.println(RED + "[ERROR] " + message + RESET);
    }
}
