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

            System.out.println("Actualizando un empleado...........");
            Employee employee =  new Employee();
            employee.setId(8);
            employee.setFirst_name("Daniel");
            employee.setPa_surname("Programador");
            employee.setMa_surname("Romero");
            employee.setEmail("dromerof@example.com");
            employee.setSalary(22000F);
            repository.save(employee);

            System.out.println("-----Empleado actualizado-------");
            repository.findAll().forEach(System.out::println);
        }

    }
}
