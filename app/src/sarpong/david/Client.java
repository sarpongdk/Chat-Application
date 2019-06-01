import java.net.*;

public class Client
{
   private String name;
   private Socket socket;
   private ReaderThread reader;
   private WriterThread writer;

   public Client(String address, int port)
   {
      try
      {
         name = "NO NAME";
         socket = new Socket(address, port);
         reader = new ReaderThread(socket);
         writer = new WriterThread(socket);
      }
      catch (Exception e)
      {
         System.err.println("Error: cannot connect to server");
      }

      reader.start();
      writer.start();
   }

   public void changeName(String name)
   {
      this.name = name;
   }

   public String getName()
   {
      return name;
   }
   
}
