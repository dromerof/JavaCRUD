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

            System.out.println("-----Lista de empleados-----");
            repository.findAll().forEach(System.out::println);

            System.out.println("-----Empleado eliminado-------");
            repository.delete(8);

            System.out.println("-----Lista de empleados-----");
            repository.findAll().forEach(System.out::println);
        }

    }
}
