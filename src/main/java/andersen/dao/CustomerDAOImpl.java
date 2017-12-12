package andersen.dao;

import andersen.model.Customer;
import andersen.model.Project;
import andersen.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDAOImpl implements CrudDAO<Customer> {
    private Connection connection;

    public CustomerDAOImpl() {
        connection = DBUtil.getConnection();
    }

    @Override
    public void create(Customer customer) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("INSERT INTO customer(firstName, lastName, address) VALUES (?,?,?)");
            preparedStatement.setString(1, customer.getFirstName());
            preparedStatement.setString(2, customer.getLastName());
            preparedStatement.setString(3, customer.getAddress());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Customer read(Long id) {
        Customer customer = new Customer();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("SELECT * FROM customer WHERE id=?");
            preparedStatement.setLong(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                customer.setId(rs.getLong("id"));
                customer.setFirstName(rs.getString("firstName"));
                customer.setLastName(rs.getString("lastName"));
                customer.setAddress(rs.getString("address"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    @Override
    public void update(Customer customer) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("UPDATE customer SET firstName=?, lastName=?, address=?" +
                            "WHERE id=?");
            preparedStatement.setString(1, customer.getFirstName());
            preparedStatement.setString(2, customer.getLastName());
            preparedStatement.setString(3, customer.getAddress());
            preparedStatement.setLong(4, customer.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Long id) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("DELETE FROM customer WHERE id=?");
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addProjects(Customer customer, Project project) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("INSERT INTO " +
                            "customer_project(customer_id, project_id) VALUES (?,?)");
            preparedStatement.setInt(1, Math.toIntExact(customer.getId()));
            preparedStatement.setInt(2, Math.toIntExact(project.getId()));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
