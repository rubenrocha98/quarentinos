package org.academiadecodigo.apiores.quarentinos.persistence.dao;

import org.academiadecodigo.apiores.quarentinos.persistence.model.Model;

import java.util.List;

public interface Dao<T extends Model> {

    List<T> findAll();

    T find(Integer id);

    T saveOrUpdate(T object);

    void delete(Integer id);
}
