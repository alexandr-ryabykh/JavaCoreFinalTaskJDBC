package andersen.dao;

import andersen.model.Skill;
import andersen.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SkillDAOImpl implements CrudDAO<Skill> {
    private Connection connection;

    public SkillDAOImpl() {
        connection = DBUtil.getConnection();
    }

    @Override
    public void create(Skill skill) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("INSERT INTO skill(name) VALUES (?)");
            preparedStatement.setString(1, skill.getName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Skill read(Long id) {
        Skill skill = new Skill();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("SELECT * FROM skill WHERE id=?");
            preparedStatement.setLong(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                skill.setId(rs.getLong("id"));
                skill.setName(rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return skill;
    }


    @Override
    public void update(Skill skill) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("UPDATE skill SET name=?" +
                            "WHERE id=?");
            preparedStatement.setString(1, skill.getName());
            preparedStatement.setLong(2, skill.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Long id) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("DELETE FROM skill WHERE id=?");
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
