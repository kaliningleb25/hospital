package com.polytech.bd.bd_client_for_hospital.service;

import com.polytech.bd.bd_client_for_hospital.dao.PeopleDao;
import com.polytech.bd.bd_client_for_hospital.entity.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeopleServiceImpl implements PeopleService {

    @Autowired
    PeopleDao peopleDao;

    @Override
    public List<People> getAllPeople() {
        return peopleDao.findAll();
    }

    @Override
    public People getById(Long id) {
        return peopleDao.find(id);
    }

    @Override
    public void edit(Long id, People people) {
        peopleDao.update(id, people);
    }

    @Override
    public void delete(Long id) {
        peopleDao.delete(id);
    }

    @Override
    public void add(People people) {
        peopleDao.create(people);
    }
}
