package ru.innopolis.publicator.server.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@SuppressWarnings("PMD")
@MappedSuperclass
abstract class AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @Version
    @Column
    private Long version;
}
