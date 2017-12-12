package andersen.dao;

import andersen.model.Company;
import andersen.model.Project;
import andersen.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CompanyDAOImpl implements CrudDAO<Company> {
    private Connection connection;

    public CompanyDAOImpl() {
        connection = DBUtil.getConnection();
    }

    @Override
    public void create(Company company) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("INSERT INTO company(name) VALUES (?)");
            preparedStatement.setString(1, company.getName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Company read(Long id) {
        Company company = new Company();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("SELECT * FROM company WHERE id=?");
            preparedStatement.setLong(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                company.setId(rs.getLong("id"));
                company.setName(rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return company;
    }

    @Override
    public void update(Company company) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("UPDATE company SET name=?" +
                            "WHERE id=?");
            preparedStatement.setString(1, company.getName());
            preparedStatement.setLong(2, company.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Long id) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("DELETE FROM company WHERE id=?");
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addProjects(Company company, Project project) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("INSERT INTO " +
                            "company_project(company_id, project_id) VALUES (?,?)");
            preparedStatement.setLong(1, company.getId());
            preparedStatement.setLong(2, project.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Company readProject(Long company_id) {
        Company company = new Company();
        Project project = new Project();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("SELECT * FROM company_project LEFT JOIN company ON company_project.company_id = company.id WHERE company.id=?");
            preparedStatement.setLong(1, company_id);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                company.setId(rs.getLong("company_id"));
                project.setId(rs.getLong("project_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return company;
    }
}
