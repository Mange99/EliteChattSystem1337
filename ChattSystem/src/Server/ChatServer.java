package Server;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.util.HashSet;

public class ChatServer {

	protected static final int PORT = 9001;
    protected static HashSet<String> names = new HashSet<String>();
    protected static HashSet<PrintWriter> writers = new HashSet<PrintWriter>();

    public static void main(String[] args) throws Exception {
        System.out.println("The chat server is running.");
        ServerSocket listener = new ServerSocket(PORT);

         try {
            while (true) {
                new Handler(listener.accept()).start();
            }
        } finally {
            listener.close();
        }
    }    
}