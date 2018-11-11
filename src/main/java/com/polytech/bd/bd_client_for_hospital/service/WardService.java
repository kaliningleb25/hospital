package com.polytech.bd.bd_client_for_hospital.service;

import com.polytech.bd.bd_client_for_hospital.entity.Ward;

import java.util.List;

public interface WardService {

    List<Ward> getAllWards();

    Ward getById(Long id);

    void edit(Long id, Ward ward);

    void delete(Long id);

    void add(Ward ward);
}
