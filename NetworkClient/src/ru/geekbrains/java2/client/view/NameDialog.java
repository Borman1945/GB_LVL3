package ru.geekbrains.java2.client.view;

import ru.geekbrains.java2.client.controller.ClientController;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class NameDialog extends JFrame{
    private JPanel contentPane;
    private JButton buttonChange;
    private JButton buttonCancel;
    private JTextField loginText;

    private ClientController controller;

    public NameDialog(ClientController controller) throws HeadlessException {
             this.controller = controller;
             setContentPane(contentPane);
                     getRootPane().setDefaultButton(buttonChange);
                     setSize(400, 250);
                     setLocationRelativeTo(null);
              buttonChange.addActionListener(e -> changeName());
              buttonCancel.addActionListener(e -> onCancel());

    }


    private void onCancel() {
            this.setVisible(false);
        }

    private void changeName(){
        String newName =  loginText.getText();
        if (newName != null && !newName.trim().equals("")){
            try {
                controller.newName(newName);
                this.setVisible(false);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
