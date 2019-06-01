import java.net.*;
import java.util.Scanner;

public class WriterThread extends Thread
{
   private Socket socket;
   private PrintWriter writer;

   public WriterThread(Socket socket)
   {
      try
      {
         this.socket = socket;
         this.reader = new PrintWriter(this.socket.getOutputStream());
      }
      catch (Exception e)
      {
         System.err.println("Error: WriterThread cannot read from server");
         System.exit(1);
      }
   }

   private String sendMessage()
   {
      String message = "";

      try
      {
         message = reader.readLine();
      }
      catch (Exception e)
      {
         System.err.println("Error: readMessage error");
      }

      return message;
   }

   @Override
   public void run()
   {
      while (true)
      {
         String message = readMessage();
      }
   }
}
