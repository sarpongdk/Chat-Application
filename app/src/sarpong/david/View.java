package sarpong.david;

import javax.swing.*;
import javax.swing.border.*;

import java.awt.*;
import java.awt.event.*;

public class View extends JFrame
{
   private JPanel titlePanel, contentPanel, buttonsPanel, sendMessagePanel, textPanel;
   private JButton login, logout, exit, send;
   private JTextArea receivedMessages, users;
   private JTextField sendMessageField;
   private JLabel title;
   private JScrollPane scrollPane;

   public View()
   {
      titlePanel = new JPanel();
      contentPanel = new JPanel();
      contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
      buttonsPanel = new JPanel(new FlowLayout());
      sendMessagePanel = new JPanel(new FlowLayout());
      textPanel = new JPanel(new BorderLayout());
   
      login = new JButton("Login");
      logout = new JButton("Logout");
      exit = new JButton("Exit");
      send = new JButton("Send");

      sendMessageField = new JTextField(40);
      receivedMessages = new JTextArea(20, 45);
      scrollPane = new JScrollPane(receivedMessages);
      receivedMessages.setEditable(false);
      receivedMessages.setLineWrap(true);
      users = new JTextArea(20, 15);
      users.setEditable(false);
      Border border = BorderFactory.createLineBorder(Color.BLACK);
      receivedMessages.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10)));
      
      title = new JLabel("Chat Messages");
      titlePanel.add(title);

      buttonsPanel.add(login);
      buttonsPanel.add(logout);
      buttonsPanel.add(exit);

      sendMessagePanel.add(sendMessageField);
      sendMessagePanel.add(send);

      textPanel.add(titlePanel, BorderLayout.NORTH);
      textPanel.add(users, BorderLayout.EAST);
      textPanel.add(scrollPane, BorderLayout.CENTER);

      contentPanel.add(textPanel);
      contentPanel.add(sendMessagePanel);
      contentPanel.add(buttonsPanel);

      initActionListeners();

      add(contentPanel);
      pack();
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setVisible(true);
   }

   public void appendSenderMessage(String message)
   {
     
   }

   private void initActionListeners()
   {
      exit.addActionListener(new ActionListener() {
         
         @Override
         public void actionPerformed(ActionEvent e)
         {
            exit();
         }
      });
   }

   public void displayReceivedMessage(String message)
   {
      receivedMessages.append(message + "\n");  
   }

   public void addSendClickListener(ActionListener listener)
   {
      send.addActionListener(listener);
   }

   public void exit()
   {
      dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
   }

   public String getMessage()
   {
      String msg = sendMessageField.getText();
      sendMessageField.setText("");

      return msg;
   }

   public static void main(String[] args)
   {
      View view = new View();
   }

}
