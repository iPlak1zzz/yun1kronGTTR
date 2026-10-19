package worker;

public class WorkerApp {
    public static void main(String[] args) {
        TerminalUI.clear();
        System.out.println("=== HACKER-NET: WORKER NODE (LINUX) ===");
        
        int port = 8888;
        NetworkServer server = new NetworkServer(port);
        server.start();
    }
}
