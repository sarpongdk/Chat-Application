package sarpong.david;

import java.awt.event.*;

public class ChatController implements ActionListener
{
   private ChatClient client;
   private ChatGUI view;

   public ChatController(ChatClient client, ChatGUI view)
   {
      this.view = view;
      this.client = client;

      this.view.addSendListener(this);
   }

   @Override
   public void actionPerformed(ActionEvent e)
   {
      String message = view.getMessageToSend();
      client.sendMessage(message);
   }

   public static void main(String[] args)
   {
      ChatClient client = new ChatClient();
      ChatGUI view = new ChatGUI();
      ChatController controller = new ChatController(client, view);
   }
}
