package ru.innopolis.publicator.server.repository;

import ru.innopolis.publicator.server.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    User findByLogin(String login) throws SQLException;
}
