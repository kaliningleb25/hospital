package com.polytech.bd.bd_client_for_hospital.dao;

import com.polytech.bd.bd_client_for_hospital.db_config.ConfigDB;
import com.polytech.bd.bd_client_for_hospital.entity.People;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

@Repository
public class PeopleDaoImpl implements PeopleDao {

    private final ConfigDB configDB;
    private final Statement stmt;

    public PeopleDaoImpl() throws SQLException {
        configDB = new ConfigDB();
        stmt = configDB.getStatement();
    }

    @Override
    public List<People> findAll() {
        List<People> peopleList = new LinkedList<>();
        String sql = "SELECT id, first_name, last_name, pather_name, diagnosis_id, ward_id FROM people";
        try (ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Long id = rs.getLong("id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String patherName = rs.getString("pather_name");
                Long diagnosisId = rs.getLong("diagnosis_id");
                Long wardId = rs.getLong("ward_id");

                peopleList.add(new People(id, firstName, lastName, patherName, diagnosisId, wardId));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return peopleList;
    }

    @Override
    public People find(Long id) {
        People people = null;
        String sql = "SELECT id, first_name, last_name, pather_name, diagnosis_id, ward_id FROM people WHERE id=?";

        try (PreparedStatement preparedStatement = configDB.getPreparedStatement(sql)) {
            preparedStatement.setLong(1, id);
            try (ResultSet rs = preparedStatement.executeQuery()) {
                while (rs.next()) {
                    String firstName = rs.getString("first_name");
                    String lastName = rs.getString("last_name");
                    String patherName = rs.getString("pather_name");
                    Long diagnosisId = rs.getLong("diagnosis_id");
                    Long wardId = rs.getLong("ward_id");

                    people = new People(id, firstName, lastName, patherName, diagnosisId, wardId);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return people;
    }

    @Override
    public void create(People people) {
        Long id = people.getId();
        String firstName = people.getFirstName();
        String lastName = people.getLastName();
        String patherName = people.getPatherName();
        Long diagnosisId = people.getDiagnosisId();
        Long wardId = people.getWardId();

        String sql = "INSERT INTO people (id, first_name, last_name, pather_name, diagnosis_id, ward_id) VALUES (?,?,?,?,?,?)";

        try(PreparedStatement preparedStatement = configDB.getPreparedStatement(sql)) {
            preparedStatement.setLong(1, id);
            preparedStatement.setString(2, firstName);
            preparedStatement.setString(3, lastName);
            preparedStatement.setString(4, patherName);
            preparedStatement.setLong(5, diagnosisId);
            preparedStatement.setLong(6, wardId);

            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Long id, People people) {
        String firstName = people.getFirstName();
        String lastName = people.getLastName();
        String patherName = people.getPatherName();
        Long diagnosisId = people.getDiagnosisId();
        Long wardId = people.getWardId();

        String sql = "UPDATE people SET first_name=?, last_name=?, pather_name=?, diagnosis_id=?, ward_id=? WHERE id=?";

        try (PreparedStatement preparedStatement = configDB.getPreparedStatement(sql)) {
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, patherName);
            preparedStatement.setLong(4, diagnosisId);
            preparedStatement.setLong(5, wardId);
            preparedStatement.setLong(6, id);

            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM people WHERE id=?";

        try(PreparedStatement preparedStatement = configDB.getPreparedStatement(sql)) {
            preparedStatement.setLong(1, id);

            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
