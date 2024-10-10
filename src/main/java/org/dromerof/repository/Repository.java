package org.dromerof.repository;

import java.sql.SQLException;
import java.util.List;

public interface Repository<T> {
    List<T> findAll() throws SQLException;

    T getByID(Integer id);

    void save(T t);

    void delete(Integer id);
}
