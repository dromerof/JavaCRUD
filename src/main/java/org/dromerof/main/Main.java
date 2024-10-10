package org.dromerof.main;

import org.dromerof.model.Employee;
import org.dromerof.repository.EmployeesRepository;
import org.dromerof.repository.Repository;
import org.dromerof.util.DatabaseConnection;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {

        try (Connection myConn = DatabaseConnection.getInstance()){
            Repository<Employee> repository = new EmployeesRepository();

            repository.findAll().forEach(System.out::println);
        }

    }
}
