package ru.innopolis.publicator.server.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Table(name="users")
@javax.persistence.Entity
public class User extends AbstractEntity implements Serializable{


    @Column
    String login;

    @Column
    String password;

    @Column
    Boolean active;


}
