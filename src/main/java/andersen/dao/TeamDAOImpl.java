package andersen.dao;

import andersen.model.Developer;
import andersen.model.Team;
import andersen.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TeamDAOImpl implements CrudDAO<Team> {
    private Connection connection;

    public TeamDAOImpl() {
        connection = DBUtil.getConnection();
    }

    @Override
    public void create(Team team) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("INSERT INTO team(name) VALUES (?)");
            preparedStatement.setString(1, team.getName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Team read(Long id) {
        Team team = new Team();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("SELECT * FROM team WHERE id=?");
            preparedStatement.setLong(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                team.setId(rs.getLong("id"));
                team.setName(rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return team;
    }

    @Override
    public void update(Team team) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("UPDATE team SET name=?" +
                            "WHERE id=?");
            preparedStatement.setString(1, team.getName());
            preparedStatement.setLong(2, team.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Long id) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("DELETE FROM team WHERE id=?");
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addDevelopers(Team team, Developer developer) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("INSERT INTO team_developer(team_id, developer_id) VALUES (?,?)");
            preparedStatement.setInt(1, Math.toIntExact(team.getId()));
            preparedStatement.setInt(2, Math.toIntExact(developer.getId()));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
