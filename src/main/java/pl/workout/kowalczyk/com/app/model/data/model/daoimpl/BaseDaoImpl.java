package pl.workout.kowalczyk.com.app.model.data.model.daoimpl;

import pl.workout.kowalczyk.com.app.model.data.model.dao.BaseDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by JK on 2016-09-03.
 */
public abstract class BaseDaoImpl<T> implements BaseDao<T> {

    private Class<T> entityClass;

    @PersistenceContext
    private EntityManager entityManager;

    public BaseDaoImpl() {
        entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public List<T> getAll() {
        return entityManager
                .createQuery("Select a from T a", entityClass)
                .getResultList();
    }

    public void save(T domain) {
        entityManager.persist(domain);
    }


    public void update(T domain) {
        entityManager.merge(domain);
    }

    public void delete(T domain) {
        entityManager.remove(domain);
    }

    public T get(Long id) {
        return entityManager.find(entityClass, id);
    }
}