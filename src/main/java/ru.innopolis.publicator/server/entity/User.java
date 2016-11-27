package ru.innopolis.publicator.server.entity;

import lombok.Data;
import lombok.Getter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Table(name="users")
@Entity
public class User extends AbstractEntity implements Serializable{

    @Getter
    @Column
    String login;

    @Getter
    @Column
    String password;

    @Column
    Boolean active;

    @Getter
    @ManyToMany(cascade = CascadeType.ALL,  fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "roles_name")})
    private List<Role> roles;

}
