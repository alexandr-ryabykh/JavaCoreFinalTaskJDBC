package andersen.dao;

import andersen.model.Developer;
import andersen.model.Skill;
import andersen.util.DBUtil;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static java.math.BigInteger.*;

public class DeveloperDAOImpl implements CrudDAO<Developer> {

    private Connection connection;

    public DeveloperDAOImpl() {
        connection = DBUtil.getConnection();
    }

    @Override
    public void create(Developer developer) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("INSERT INTO developer(firstName, lastName, speciality, salary) VALUES (?,?,?,?)");
            preparedStatement.setString(1, developer.getFirstName());
            preparedStatement.setString(2, developer.getLastName());
            preparedStatement.setString(3, developer.getSpeciality());
            preparedStatement.setBigDecimal(4, developer.getSalary());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Developer read(Long id) {
        Developer developer = new Developer();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("SELECT * FROM developer WHERE id=?");
            preparedStatement.setLong(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                developer.setId(rs.getLong("id"));
                developer.setFirstName(rs.getString("firstName"));
                developer.setLastName(rs.getString("lastName"));
                developer.setSpeciality(rs.getString("speciality"));
                developer.setSalary(rs.getBigDecimal("salary"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return developer;
    }


    @Override
    public void update(Developer developer) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("UPDATE developer SET firstName=?, lastName=?, speciality=?, salary=?" +
                            "WHERE id=?");
            preparedStatement.setString(1, developer.getFirstName());
            preparedStatement.setString(2, developer.getLastName());
            preparedStatement.setString(3, developer.getSpeciality());
            preparedStatement.setBigDecimal(4, developer.getSalary());
            preparedStatement.setLong(5, developer.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Long id) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("DELETE FROM developer WHERE id=?");
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addSkills(Developer developer, Skill skill) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("INSERT INTO developer_skills (developer_id, skill_id) VALUES (?,?)");
            preparedStatement.setInt(1, Math.toIntExact((developer.getId())));
            preparedStatement.setInt(2, Math.toIntExact(skill.getId()));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
