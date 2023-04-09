package pro.sky.java.course2.list;

import java.util.Collection;

public interface Service {


    Employee addEmployee(String firstName, String lastName);

    Employee removeEmployee(String firstName, String lastName);

    Employee findEmployee(String firstName, String lastName);

    String getEmployee(Integer num);

    Collection<Employee> findAll();
}
