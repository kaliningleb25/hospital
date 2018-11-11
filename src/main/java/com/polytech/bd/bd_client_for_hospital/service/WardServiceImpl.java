package com.polytech.bd.bd_client_for_hospital.service;

import com.polytech.bd.bd_client_for_hospital.dao.WardDao;
import com.polytech.bd.bd_client_for_hospital.entity.Ward;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WardServiceImpl implements WardService {

    @Autowired
    WardDao wardDao;

    @Override
    public List<Ward> getAllWards() {
        return wardDao.findAll();
    }

    @Override
    public Ward getById(Long id) {
        return wardDao.find(id);
    }

    @Override
    public void edit(Long id, Ward ward) {
        wardDao.update(id, ward);
    }

    @Override
    public void delete(Long id) {
        wardDao.delete(id);
    }

    @Override
    public void add(Ward ward) {
        wardDao.create(ward);
    }
}
