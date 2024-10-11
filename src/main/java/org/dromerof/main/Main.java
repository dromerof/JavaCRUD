package org.dromerof.main;

import org.dromerof.model.Employee;
import org.dromerof.repository.EmployeeRepository;
import org.dromerof.repository.Repository;
import org.dromerof.util.DatabaseConnection;
//import org.dromerof.view.SwingApp;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {

        try (Connection myConn = DatabaseConnection.getInstance()) {
            if (myConn.getAutoCommit()) {

                myConn.setAutoCommit((false));
            }

            try {
                Repository<Employee> repository = new EmployeeRepository(myConn);

                System.out.println("---------Insertar un nuevo cliente---------");
                Employee employee = new Employee();

                /*
                employee.setFirst_name("Andres");
                employee.setPa_surname("Romero");
                employee.setMa_surname("Fontalvo");
                employee.setEmail("andres@example.com");
                employee.setSalary(20000F);
                employee.setCurp("JHGTYUIOLKJHGDFETW");
                repository.save(employee);
                myConn.commit();*/

                employee.setFirst_name("Dany");
                employee.setPa_surname("Puerta");
                employee.setMa_surname("Romero");
                employee.setEmail("Dany@example.com");
                employee.setSalary(30000F);
                employee.setCurp("JHGTYUIOLKJHGDFETW");
                repository.save(employee);
                myConn.commit();

            } catch (SQLException e) {
                myConn.rollback();
                throw new RuntimeException(e);
            }
        }

    }
}
