package kg.gov.mf.loan.docflow.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.ParameterizedType;
import java.util.List;

public class GenericDaoImpl<T> implements GenericDao<T>
{
    @Autowired
    private SessionFactory sessionFactory;

    private Class<T> entityClass;

    public GenericDaoImpl() {
        entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }


    protected final Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public void add(T entity) {
        getCurrentSession().persist(entity);
    }

    public List<T> list() {
        return getCurrentSession().createQuery("from " + entityClass.getName()).list();
    }

    public T getById(Long id) {
        return (T) getCurrentSession().get(entityClass, id );
    }

    public void update(T entity) {
        getCurrentSession().update(entity);
    }

    public void remove(Long id) {
        T entity = getById(id);
        getCurrentSession().delete(entity);
    }
}
