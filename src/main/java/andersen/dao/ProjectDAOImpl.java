package andersen.dao;

import andersen.model.Project;
import andersen.model.Team;
import andersen.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProjectDAOImpl implements CrudDAO<Project> {
    private Connection connection;

    public ProjectDAOImpl() {
        connection = DBUtil.getConnection();
    }

    @Override
    public void create(Project project) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("INSERT INTO project(name) VALUES (?)");
            preparedStatement.setString(1, project.getName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Project read(Long id) {
        Project project = new Project();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("SELECT * FROM project WHERE id=?");
            preparedStatement.setLong(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                project.setId(rs.getLong("id"));
                project.setName(rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return project;
    }

    @Override
    public void update(Project project) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("UPDATE project SET name=?" +
                            "WHERE id=?");
            preparedStatement.setString(1, project.getName());
            preparedStatement.setLong(2, project.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Long id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM project WHERE id=?");
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addTeams(Project project, Team team) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("INSERT INTO project_team(project_id, team_id) VALUES (?,?)");
            preparedStatement.setInt(1, Math.toIntExact(project.getId()));
            preparedStatement.setInt(2, Math.toIntExact(team.getId()));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
