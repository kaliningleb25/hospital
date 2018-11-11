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
public class Ward {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer maxCount;
    private Long diagnosisId;

    public Ward(Long id, String name, Integer maxCount, Long diagnosisId) {
        this.id = id;
        this.name = name;
        this.maxCount = maxCount;
        this.diagnosisId = diagnosisId;
    }
}
