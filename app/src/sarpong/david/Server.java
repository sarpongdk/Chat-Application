import java.io.*;
import java.util.*;
import java.net.*;

public class Server implements Runnable
{
   private static final int PORT = 5000;

   private Thread acceptThread;
   private ServerSocket serverSocket;
   private WriterThread writer;
   private ReaderThread reader;
   ArrayList<Client> clients;

   public Server()
   {
      serverSocket = new ServerSocket(PORT);
      clients = new ArrayList<>();
      acceptThread = new Thread(this);

      while (true)
      {
         Socket socket = serverSocket.accept();
         clients.add(socket);
         try
         {
            writer = new PrintWriter(socket.getOutputStream());
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream));
         }
         catch (Exception e)
         {
            System.err.println("Error starting the server");
            System.exit(1);
         }
      }
   }

   public void broadcastToAll(String message)
   {
      for (Socket socket: clients)
      {
         try
         {
            writer = new PrintWriter(socket.getOutputStream());
            writer.println(message);
         }
         catch (Exception e)
         {
            System.err.println("Error starting the server");
            System.exit(1);
         }
      }
   }


}
