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

            System.out.println("-----Lista de empleados-----\n");
            repository.findAll().forEach(System.out::println);

            System.out.println("--------Insertando un empleado-----------\n");
            Employee employee =  new Employee();
            employee.setFirst_name("Daniel");
            employee.setPa_surname("Programador");
            employee.setMa_surname("Romero");
            employee.setEmail("dromerof@example.com");
            employee.setSalary(2000F);
            repository.save(employee);

            System.out.println("-----Con el nuevo empleado insertado-------");
            repository.findAll().forEach(System.out::println);
        }

    }
}
