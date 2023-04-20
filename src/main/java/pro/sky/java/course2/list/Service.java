package pro.sky.java.course2.list;

import java.util.Collection;

public interface Service {


    Employee addEmployee(String firstName, String lastName, int department, double salary);

    Employee removeEmployee(String firstName, String lastName, int department, double salary);

    Employee findEmployee(String firstName, String lastName, int department, double salary);

    Collection<Employee> findAll();
}
