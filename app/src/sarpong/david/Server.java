package sarpong.david;

import java.io.*;
import java.util.*;

import java.net.*;

public class Server
{
   private final int port;
   private int numOfConnections;
   private String defaultName = "User";
   private ServerSocket serverSocket;
   private HashMap<PrintWriter, String> clients;

   public Server(int port)
   {
      this.port = port;

      try
      {
         serverSocket = new ServerSocket(port);
         clients = new HashMap<>();
         numOfConnections = 0;

         System.out.println("Server has started!");
         
         while (true)
         {
            Socket socket = serverSocket.accept();   
            numOfConnections++;
            
            String username = defaultName + Integer.toString(numOfConnections);
            PrintWriter writer = new PrintWriter(socket.getOutputStream());
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BroadcastThread broadcastHandler = new BroadcastThread(reader, username);
            clients.put(writer, username);
         }
      }
      catch (Exception e)
      {
         e.printStackTrace();
         System.exit(1);
      }
   }

   private class BroadcastThread extends Thread
   {
      private BufferedReader reader;
      private String username;

      public BroadcastThread(BufferedReader reader, String username)
      {
         this.reader = reader;
         this.username = username;

         this.start();
      }

      public void broadcastMessage()
      {
         try
         {
            String msg;
            while ((msg = reader.readLine()) != null)
            {
               for (PrintWriter w: clients.keySet())
               {
                  System.out.println(username + ": " + msg);
                  w.println(username + ": " + msg);
                  w.flush();
               }
            }
         }
         catch (Exception e)
         {
            e.printStackTrace();
         }
      }
      
      @Override
      public void run()
      {
         while (true)
         {
            broadcastMessage();
         }
      }
   }

   public static void main(String[] args)
   {
      if (args.length != 1)
      {
         System.err.println("Usage: java Server <port number>");
         System.exit(1);
      }
      
      int port = Integer.parseInt(args[0]); 
      Server server = new Server(port);
   }
}
