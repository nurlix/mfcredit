package kg.gov.mf.loan.docflow.dao;

import java.util.List;

public interface GenericDao<T> {

    void add(T entity);
    List<T> list();
    T getById(Long id);
    void update(T entity);
    void remove(Long id);
}
