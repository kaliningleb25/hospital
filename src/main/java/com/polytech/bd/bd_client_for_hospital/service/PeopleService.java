package com.polytech.bd.bd_client_for_hospital.service;

import com.polytech.bd.bd_client_for_hospital.entity.People;

import java.util.List;

public interface PeopleService {
    List<People> getAllPeople();

    People getById(Long id);

    void edit(Long id, People people);

    void delete(Long id);

    void add(People people);
}
