package ru.innopolis.publicator.common.modal;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserModal implements Serializable{
    private Integer id;

    private String login;

    private String password;

    private boolean active;

}
