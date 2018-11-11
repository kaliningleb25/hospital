package com.polytech.bd.bd_client_for_hospital.dao;

import com.polytech.bd.bd_client_for_hospital.db_config.ConfigDB;
import com.polytech.bd.bd_client_for_hospital.entity.Diagnosis;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

@Repository
public class DiagnosisDaoImpl implements DiagnosisDao {

    private final ConfigDB configDB;
    private final Statement stmt;

    public DiagnosisDaoImpl() throws SQLException {
        configDB = new ConfigDB();
        stmt = configDB.getStatement();
    }

    @Override
    public List<Diagnosis> findAll() {
        List<Diagnosis> diagnosisList = new LinkedList<>();
        String sql = "SELECT id, name FROM diagnosis";
        try (ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Long id = rs.getLong("id");
                String name = rs.getString("name");

                diagnosisList.add(new Diagnosis(id, name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return diagnosisList;
    }

    @Override
    public Diagnosis find(Long id) {
        Diagnosis diagnosis = null;
        String sql = "SELECT id, name FROM diagnosis WHERE id=?";

        try (PreparedStatement preparedStatement = configDB.getPreparedStatement(sql)) {
            preparedStatement.setLong(1, id);
            try (ResultSet rs = preparedStatement.executeQuery()) {
                while (rs.next()) {
                    String name = rs.getString("name");

                    diagnosis = new Diagnosis(id, name);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return diagnosis;
    }

    @Override
    public void create(Diagnosis diagnosis) {
        Long id = diagnosis.getId();
        String name = diagnosis.getName();

        String sql = "INSERT INTO diagnosis (id, name) VALUES (?,?)";

        try (PreparedStatement preparedStatement = configDB.getPreparedStatement(sql)) {
            preparedStatement.setLong(1, id);
            preparedStatement.setString(2, name);

            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Long id, Diagnosis diagnosis) {
        String name = diagnosis.getName();

        String sql = "UPDATE diagnosis SET name=?";

        try (PreparedStatement preparedStatement = configDB.getPreparedStatement(sql)) {
            preparedStatement.setString(1, name);

            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM diagnosis WHERE id=?";

        try (PreparedStatement preparedStatement = configDB.getPreparedStatement(sql)) {
            preparedStatement.setLong(1, id);

            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
