package com.polytech.bd.bd_client_for_hospital.dao;

import com.polytech.bd.bd_client_for_hospital.BdClientForHospitalApplicationTests;
import com.polytech.bd.bd_client_for_hospital.entity.People;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
public class PeopleDaoImplTest {
    private PeopleDao peopleDao;

    public PeopleDaoImplTest() throws SQLException {
        peopleDao = new PeopleDaoImpl();
    }

    @Test
    public void testShowPeopleFirstElem() {
        People expectedFirstElem =
                new People(
                        1l, "INFECTION", "INFECTION", "INFECTION", 5L, 4L);

        People actualFirstElem = peopleDao.findAll().get(0);

        assertEquals(expectedFirstElem, actualFirstElem);
    }
}