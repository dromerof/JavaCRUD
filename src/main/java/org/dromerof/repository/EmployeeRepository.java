package org.dromerof.repository;

import org.dromerof.model.Employee;
import org.dromerof.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements Repository<Employee> {

    private Connection getConnection() throws SQLException {
        return DatabaseConnection.getConnection();
    }


    @Override
    public List<Employee> findAll() throws SQLException {
        List<Employee> employees = new ArrayList<>();

        try (Connection myConn = getConnection();
             Statement myStant = myConn.createStatement();
             ResultSet myRes = myStant.executeQuery("SELECT * FROM employees")) {
            while (myRes.next()) {
                Employee e = createEmployee(myRes);
                employees.add(e);
            }
        }
        return employees;
    }

    @Override
    public Employee getByID(Integer id) throws SQLException {
        Employee employee = null;
        try (Connection myConn = getConnection();
             PreparedStatement myStant = myConn.prepareStatement("SELECT * FROM employees WHERE id = ?")) {
            myStant.setInt(1, id);
            try (ResultSet myRes = myStant.executeQuery()) {
                if (myRes.next()) {
                    employee = createEmployee(myRes);
                }
            }
        }
        return employee;
    }

    @Override
    public void save(Employee employee) {
        String sql;
        if (employee.getId() != null && employee.getId() > 0) {
            sql = "UPDATE employees SET first_name =?, pa_surname =?, ma_surname =?, email =?, salary =?, curp =? WHERE id =?";

        } else {
            sql = "INSERT INTO employees (first_name, pa_surname, ma_surname, email, salary, curp) VALUES (?,?,?,?,?,?)";
        }
        try (Connection myConn = getConnection();
             PreparedStatement myStant = myConn.prepareStatement(sql)) {
            myStant.setString(1, employee.getFirst_name());
            myStant.setString(2, employee.getPa_surname());
            myStant.setString(3, employee.getMa_surname());
            myStant.setString(4, employee.getEmail());
            myStant.setFloat(5, employee.getSalary());
            myStant.setString(6, employee.getCurp());
            if (employee.getId() != null && employee.getId() > 0) {
                myStant.setInt(7, employee.getId());
            }
            myStant.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        try (Connection myConn = getConnection();
             PreparedStatement myStant = myConn.prepareStatement("DELETE FROM employees WHERE id=?")) {
            myStant.setInt(1, id);
            myStant.executeUpdate();
        }
    }

    private Employee createEmployee(ResultSet myRes) throws SQLException {
        Employee e = new Employee();
        e.setId(myRes.getInt("id"));
        e.setFirst_name(myRes.getString("first_name"));
        e.setPa_surname(myRes.getString("pa_surname"));
        e.setMa_surname(myRes.getString("ma_surname"));
        e.setEmail(myRes.getString("email"));
        e.setSalary(myRes.getFloat("salary"));
        e.setCurp(myRes.getString("curp"));
        return e;
    }
}
