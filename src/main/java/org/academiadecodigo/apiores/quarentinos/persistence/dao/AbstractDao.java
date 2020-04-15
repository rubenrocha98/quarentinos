package org.academiadecodigo.apiores.quarentinos.persistence.dao;

import org.academiadecodigo.apiores.quarentinos.persistence.model.Model;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public abstract class AbstractDao<T extends Model> implements Dao<T> {

    protected Class<T> modelType;

    @PersistenceContext
    private EntityManager em;

    public AbstractDao(Class<T> modelType){
        this.modelType = modelType;
    }

    @Override
    public List<T> findAll() {

        return em.createQuery("from" + modelType.getSimpleName(), modelType).getResultList();
    }

    @Override
    public T find(Integer id) {
        return em.find(modelType, id);
    }

    @Override
    public T saveOrUpdate(T object) {
        return em.merge(object);
    }

    @Override
    public void delete(Integer id) {
        em.remove(em.find(modelType, id));
    }
}
