package ru.geekbrains.java2.client.command;

import java.io.Serializable;

public class ChangeNameCommand implements Serializable {

    private final String newName;



    private final String nickname;

    public ChangeNameCommand(String newName,String login) {
        this.newName = newName;
        this.nickname = login;
    }

    public String getNewName() {
        return newName;
    }

    public String getNickname() {
        return nickname;
    }
}

