package sarpong.david;

import java.awt.event.*;
import java.awt.*;

import javax.swing.*;

public class ChatGUI extends JFrame
{
   private static final int WINDOW_WIDTH = 505;
   private static final int WINDOW_HEIGHT = 320;
   private static final int TEXTFIELD_LENGTH = 25;
   private static final int TEXTAREA_WIDTH = 15;
   private static final int TEXTAREA_HEIGHT = 40;

   private JPanel panel;
   private JTextField textField;
   private JButton send;
   private JTextArea textArea;
   private JScrollPane scrollPane;

   public ChatGUI()
   {
      panel = new JPanel();
      textField = new JTextField(TEXTFIELD_LENGTH);
      send = new JButton("Send");
      textArea = new JTextArea(TEXTAREA_WIDTH, TEXTAREA_HEIGHT);
      textArea.setLineWrap(true);
      textArea.setWrapStyleWord(true);
      textArea.setEditable(false);
      scrollPane = new JScrollPane(textArea);

      scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
      scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

      panel.add(scrollPane);
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
