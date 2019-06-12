package sarpong.david;

import java.awt.event.*;

import java.net.*;
import java.util.*;
import java.io.*;

public class Client
{
   private final String ipAddress;
   private final int port;
   private View view;
   private Socket socket;
   private BufferedReader reader;
   private PrintWriter writer;
   private ReadThreadHandler readerHandler;
   private WriteThreadHandler writerHandler;

   public Client(String ipAddress, int port)
   {
      this.port = port;
      this.ipAddress = ipAddress;

      try
      {
         view = new View();
         socket = new Socket(ipAddress, port);
         if (!socket.isConnected())
         {
            System.out.println("Socket connection has been refused!");
            System.exit(1);
         }

         reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
         readerHandler = new ReadThreadHandler(reader, view);
         readerHandler.start();

         writer = new PrintWriter(socket.getOutputStream());
         if (view == null)
         {
            writerHandler = new WriteThreadHandler(writer);
         }
         
         view.addSendClickListener(new ActionListener() {
         
            @Override     
            public void actionPerformed(ActionEvent e)
            {
               String message = view.getMessage();
               view.appendSenderMessage(message);
               writer.println(message);
               writer.flush();
            }
         });

      }
      catch (Exception e)
      {
         e.printStackTrace();
         System.exit(1);
      }
   }

   public static void main(String[] args)
   {
      if (args.length != 2)
      {
         System.err.println("Usage: java Client <ip address> <port number>");
         System.exit(1);
      }
      
      String ipAddress = args[0];
      int port = Integer.parseInt(args[1]); 
      Client client = new Client(ipAddress, port);
   }


}
