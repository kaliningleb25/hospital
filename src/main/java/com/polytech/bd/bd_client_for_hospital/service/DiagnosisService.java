package com.polytech.bd.bd_client_for_hospital.service;

import com.polytech.bd.bd_client_for_hospital.entity.Diagnosis;

import java.util.List;

public interface DiagnosisService {
    List<Diagnosis> getAllDiagnosis();

    Diagnosis getById(Long id);

    void edit(Long id, Diagnosis diagnosis);

    void delete(Long id);

    void add(Diagnosis diagnosis);
}
