package org.dromerof.main;

import org.dromerof.model.Employee;
import org.dromerof.repository.EmployeeRepository;
import org.dromerof.repository.Repository;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {

        System.out.println("------ Listando todos ------");
        Repository<Employee> repository = new EmployeeRepository();
        repository.findAll().forEach(System.out::println);

        System.out.println("------ Buscando por ID -----");
        System.out.println(repository.getByID(2));

    }
}
