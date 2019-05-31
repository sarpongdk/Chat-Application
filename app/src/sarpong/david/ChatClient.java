package sarpong.david;

import java.io.*;

import java.net.*;

public class ChatClient
{
   private static final int PORT = 5000;
   private static final String IP_ADDRESS = "127.0.0.1";

   private Socket socket;
   private PrintWriter writer;
   private BufferedReader reader;

   public ChatClient()
   {
      try
      {
         socket = new Socket(IP_ADDRESS, PORT);
         if (socket.isConnected())
         {
            writer = new PrintWriter(socket.getOutputStream());
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
         }
         else
         {
            System.out.println("Connection Failed");
            System.exit(1);
         }
      }
      catch (Exception e)
      {
         e.printStackTrace();
         System.exit(1);
      }
   }

   public void sendMessage(String msg)
   {
      writer.println(msg);
      writer.flush();
   }

   public String readMessage()
   {
      String message = "";
      try
      {
         message = reader.readLine();
      }
      catch (IOException e)
      {
         System.err.println("Cannot read from server");
         message = "Error occured";
      }

      return message;
   }
}
