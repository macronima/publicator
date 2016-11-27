package ru.innopolis.publicator.server.entity;

import lombok.Data;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "roles")
public class Role implements Serializable{

    @Column(name = "name", unique = true)
    @Setter
    private String name;
}
