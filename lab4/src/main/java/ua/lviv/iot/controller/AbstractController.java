package ua.lviv.iot.controller;

import java.sql.SQLException;
import java.util.List;

public interface AbstractController<E> {

    List<E> findAll() throws SQLException;

    default E findById(Integer id) throws SQLException {
        return null;
    }

    default void create(E entity) throws SQLException {
    }

    default void update(Integer id, E entity) throws SQLException {
    }

    default void delete(Integer id) throws SQLException {
    }

    default E findByLogin(String login) throws SQLException {
        return null;
    }

    default void update(String login, E entity) throws SQLException {
    }

    default void delete(String login) throws SQLException {
    }
}