package sarpong.david;

import java.io.*;
import java.util.*;

public class WriteThreadHandler extends Thread
{
   private final Scanner scanner = new Scanner(System.in);
   private PrintWriter writer;

   public WriteThreadHandler(PrintWriter writer)
   {
      this.writer = writer;
   }

   public void run()
   {
      while (true)
      {
         try
         {
            System.out.print("Enter message: ");
            String message = scanner.nextLine();
            writer.println(message);
            writer.flush();
         }
         catch (Exception e)
         {
            e.printStackTrace();
         }
      }
   }
}
