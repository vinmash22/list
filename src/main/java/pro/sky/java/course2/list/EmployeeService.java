package pro.sky.java.course2.list;

import java.util.*;

@org.springframework.stereotype.Service
public class EmployeeService implements Service {

    Map<String, Employee> employees = new HashMap<>();

    @Override
    public Employee addEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        int size = employees.size();
        if (size >= 10) {
            throw new EmployeeStorageIsFullException("Штат сотрудников переполнен");
        }
        if ((employees.containsKey(employee.getFullName()))) {
            throw new EmployeeAlreadyAddedException("Такой сотрудник уже есть");
        }
        employees.put(employee.getFullName(), employee);
        return employee;
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.containsKey(employee.getFullName())) {
            return employees.remove(employee.getFullName());
        }
        throw new EmployeeNotFoundException("Сотрудник не найден");
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        final Employee employeeFind = employees.get(employee.getFullName());
        if (employeeFind == null) {
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }
        return employeeFind;
    }

    @Override
    public Collection<Employee> findAll() {
        return Collections.unmodifiableCollection(employees.values());
    }
}

