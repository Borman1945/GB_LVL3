package ru.geekbrains.java2.client.view;

import ru.geekbrains.java2.client.controller.ClientController;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class ClientChat extends JFrame {

    private JPanel mainPanel;
    private JList<String> usersList;
    private JTextField messageTextField;
    private JButton sendButton;
    private JTextArea chatText;
    private JButton newNameButton;
    private JPanel textPane;
    private File log;

    private ClientController controller;

    public ClientChat(ClientController controller) {
        this.controller = controller;
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(640, 480);
        setLocationRelativeTo(null);
        setContentPane(mainPanel);
        addListeners();
        doBufferedStream();
        readLog();
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                controller.shutdown();
            }
        });
    }


    private void addListeners() {
        sendButton.addActionListener(e -> ClientChat.this.sendMessage());
        messageTextField.addActionListener(e -> sendMessage());
        newNameButton.addActionListener(e -> openNemaDialog());
    }

    private void openNemaDialog() {
        controller.activateNewName();
    }

    private void sendMessage() {
        String message = messageTextField.getText().trim();
        if (message.isEmpty()) {
            return;
        }

        appendOwnMessage(message);

        if (usersList.getSelectedIndex() < 1) {
            controller.sendMessageToAllUsers(message);
        } else {
            String username = usersList.getSelectedValue();
            controller.sendPrivateMessage(username, message);
        }

        messageTextField.setText(null);
    }

    public void appendMessage(String message) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                chatText.append(message);
                doBufferedWrite(message);
                chatText.append(System.lineSeparator());
            }
        });
    }

    private void readLog() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(log))) {
            List<String> lines = new LinkedList<>();
            for (String line; (line = bufferedReader.readLine()) != null; ) {
                if (lines.add(line) && lines.size() > 10) {
                    lines.remove(0);
                }
            }
            printLog(lines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void printLog(List<String> texts) {
        for (String message : texts) {
            chatText.append(message);
            chatText.append(System.lineSeparator());
        }
    }


    private void doBufferedStream() {
        log = new File("/home/moshkabortman/IdeaProjects/GB_LVL3/NetworkClient/log.txt");
    }

    private void doBufferedWrite(String text) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(log, true))) {
            bufferedWriter.write(text);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    private void appendOwnMessage(String message) {
        appendMessage("Я: " + message);
    }


    public void showError(String message) {
        JOptionPane.showMessageDialog(this, "Failed to send message!");
    }

    public void updateUsers(List<String> users) {
        SwingUtilities.invokeLater(() -> {
            DefaultListModel<String> model = new DefaultListModel<>();
            model.addAll(users);
            usersList.setModel(model);
        });
    }


}
