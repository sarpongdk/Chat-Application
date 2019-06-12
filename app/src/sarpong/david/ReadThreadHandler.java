package sarpong.david;

import java.io.*;

public class ReadThreadHandler extends Thread
{
   private BufferedReader reader;
   private View view;

   public ReadThreadHandler(BufferedReader reader)
   {
      this.reader = reader;
      this.view = null;
   }

   public ReadThreadHandler(BufferedReader reader, View view)
   {
      this.reader = reader;
      this.view = view;
   }

   public void readMessages()
   {
      try
      {
         String message;
         while ((message = reader.readLine()) != null)
         {
            if (view != null)
            {
               view.displayReceivedMessage(message);
            }

            System.out.println(message);
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
         readMessages();
      }
   }
}
