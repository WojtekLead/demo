package com.example.demo.services;

public interface CrudService<T, ID> {

    Iterable<T> findAll();

    T findById(ID id);

    T save(T entity);

    void delete(T t);

    void deleteById(ID id);

}
