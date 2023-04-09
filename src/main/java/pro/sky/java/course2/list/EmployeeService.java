package pro.sky.java.course2.list;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@org.springframework.stereotype.Service
public class EmployeeService implements Service {

    List<Employee> employees = new ArrayList<>();

    @Override
    public Employee addEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        int size = employees.size();
        if (size >= 10) {
            throw new EmployeeStorageIsFullException("Штат сотрудников переполнен");
        }
        if ((employees.contains(employee))) {
            throw new EmployeeAlreadyAddedException("Такой сотрудник уже есть");
        }
        employees.add(employee);
        return employee;
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            employees.remove(employee);
            return employee;
        }
        throw new EmployeeNotFoundException("Сотрудник не найден");
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            return employee;
        }
        throw new EmployeeNotFoundException("Сотрудник не найден");
    }

    @Override
    public String getEmployee(Integer num) {
        final Employee employee;
        employee = employees.get(num);
        //final String employeeString = ""
          //      + employee.getFirstName() + ""
            //    + employee.getLastName();
        return employee.toString();
    }
    @Override
    public Collection<Employee> findAll(){
        return Collections.unmodifiableList(employees);
    }
}

