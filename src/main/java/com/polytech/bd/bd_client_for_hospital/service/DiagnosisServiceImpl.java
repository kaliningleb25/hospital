package com.polytech.bd.bd_client_for_hospital.service;

import com.polytech.bd.bd_client_for_hospital.dao.DiagnosisDao;
import com.polytech.bd.bd_client_for_hospital.entity.Diagnosis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiagnosisServiceImpl implements DiagnosisService {

    @Autowired
    DiagnosisDao diagnosisDao;

    @Override
    public List<Diagnosis> getAllDiagnosis() {
        return diagnosisDao.findAll();
    }

    @Override
    public Diagnosis getById(Long id) {
        return diagnosisDao.find(id);
    }

    @Override
    public void edit(Long id, Diagnosis diagnosis) {
        diagnosisDao.update(id, diagnosis);
    }

    @Override
    public void delete(Long id) {
        diagnosisDao.delete(id);
    }

    @Override
    public void add(Diagnosis diagnosis) {
        diagnosisDao.create(diagnosis);
    }
}
