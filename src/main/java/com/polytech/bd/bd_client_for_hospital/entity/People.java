package com.polytech.bd.bd_client_for_hospital.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class People {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String patherName;
    private Long diagnosisId;
    private Long wardId;

    public People(Long id, String firstName, String lastName, String patherName, Long diagnosisId, Long wardId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.patherName = patherName;
        this.diagnosisId = diagnosisId;
        this.wardId = wardId;
    }
}