package com.polytech.bd.bd_client_for_hospital.dao;

import com.polytech.bd.bd_client_for_hospital.db_config.ConfigDB;
import com.polytech.bd.bd_client_for_hospital.entity.Ward;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

@Repository
public class WardDaoImpl implements WardDao {

    private final ConfigDB configDB;
    private final Statement stmt;

    public WardDaoImpl() throws SQLException {
        configDB = new ConfigDB();
        stmt = configDB.getStatement();
    }

    @Override
    public List<Ward> findAll() {
        List<Ward> wardList = new LinkedList<>();
        String sql = "SELECT id, name, max_count, diagnosis_id FROM wards";
        try (ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Long id = rs.getLong("id");
                String name = rs.getString("name");
                Integer maxCount = rs.getInt("max_count");
                Long diagnosisId = rs.getLong("diagnosis_id");

                wardList.add(new Ward(id, name, maxCount, diagnosisId));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return wardList;
    }

    @Override
    public Ward find(Long id) {
        Ward ward = null;
        String sql = "SELECT id, name, max_count, diagnosis_id FROM wards WHERE id=?";

        try (PreparedStatement preparedStatement = configDB.getPreparedStatement(sql)) {
            preparedStatement.setLong(1, id);
            try (ResultSet rs = preparedStatement.executeQuery()) {
                while (rs.next()) {
                    String name = rs.getString("name");
                    Integer maxCount = rs.getInt("max_count");
                    Long diagnosisId = rs.getLong("diagnosis_id");

                    ward = new Ward(id, name, maxCount, diagnosisId);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ward;
    }

    @Override
    public void create(Ward ward) {
        Long id = ward.getId();
        String name = ward.getName();
        Integer maxCount = ward.getMaxCount();
        Long diagnosisId = ward.getDiagnosisId();

        String sql = "INSERT INTO wards (id, name, max_count, diagnosis_id) VALUES (?,?,?,?)";

        try (PreparedStatement preparedStatement = configDB.getPreparedStatement(sql)) {
            preparedStatement.setLong(1, id);
            preparedStatement.setString(2, name);
            preparedStatement.setInt(3, maxCount);
            preparedStatement.setLong(4, diagnosisId);

            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Long id, Ward ward) {
        String name = ward.getName();
        Integer maxCount = ward.getMaxCount();
        Long diagnosisId = ward.getDiagnosisId();

        String sql = "UPDATE wards SET name=?, max_count=?, diagnosis_id=?";

        try (PreparedStatement preparedStatement = configDB.getPreparedStatement(sql)) {
            preparedStatement.setString(1, name);
            preparedStatement.setInt(3, maxCount);
            preparedStatement.setLong(4, diagnosisId);

            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM wards WHERE id=?";

        try (PreparedStatement preparedStatement = configDB.getPreparedStatement(sql)) {
            preparedStatement.setLong(1, id);

            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
