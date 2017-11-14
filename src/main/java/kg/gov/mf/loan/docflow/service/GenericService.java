package kg.gov.mf.loan.docflow.service;

import java.util.List;

public interface GenericService<T> {

    void add(T entity);
    List<T> list();
    T getById(Long id);
    void update(T entity);
    void remove(Long id);
}
