package kg.gov.mf.loan.docflow.service;

import kg.gov.mf.loan.docflow.dao.GenericDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class GenericServiceImpl<T> implements GenericService<T> {

    @Autowired
    private GenericDao<T> dao;

    @Override
    @Transactional
    public void add(T entity) {
        dao.add(entity);
    }

    @Override
    @Transactional
    public List<T> list() {
        return dao.list();
    }

    @Override
    @Transactional
    public T getById(Long id) {
        return dao.getById(id);
    }

    @Override
    @Transactional
    public void update(T entity) {
        dao.update(entity);
    }

    @Override
    @Transactional
    public void remove(Long id) {
        dao.remove(id);
    }
}
