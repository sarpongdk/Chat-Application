package sarpong.david;

import java.awt.event.*;
import java.awt.*;

import javax.swing.*;

public class ChatGUI extends JFrame
{
   private static final int WINDOW_WIDTH = 405;
   private static final int WINDOW_HEIGHT = 500;
   private static final int TEXTFIELD_LENGTH = 25;

   private JPanel panel;
   private JTextField textField;
   private JButton send;
   
   public ChatGUI()
   {
      panel = new JPanel();
      textField = new JTextField(TEXTFIELD_LENGTH);
      send = new JButton("Send");

      panel.add(textField);
      panel.add(send);

      add(panel);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
      pack();
      setVisible(true);
   }

   public String getMessageToSend()
   {
      String message = textField.getText();
      textField.setText("");

      return message;
   }

   public void addSendListener(ActionListener listener)
   {
      send.addActionListener(listener);
   }

   public static void main(String[] args)
   {
      ChatGUI chat = new ChatGUI();
   }
}
