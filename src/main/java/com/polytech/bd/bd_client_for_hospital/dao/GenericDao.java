package com.polytech.bd.bd_client_for_hospital.dao;

import java.util.List;

public interface GenericDao<T> {
    List<T> findAll();

    T find(Long id);

    void create(T obj);

    void update(Long id, T obj);

    void delete(Long id);
}
