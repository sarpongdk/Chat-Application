import java.net.*;

public class ReaderThread extends Thread
{
   private Socket socket;
   private BufferedReader reader;

   public ReaderThread(Socket socket)
   {
      try
      {
         this.socket = socket;
         this.reader = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
      }
      catch (Exception e)
      {
         System.err.println("Error: ReaderThread cannot read from server");
         System.exit(1);
      }
   }

   private String readMessage()
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
