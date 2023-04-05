package pro.sky.java.course2.list;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Service
public class EmployeeService implements Service {
    List<Employee> employees = new ArrayList<>();

    @Override
    public void addEmployee(Employee employee) {
        int size = employees.size();
        if (size >= 10) {
            throw new EmployeeStorageIsFullException("Штат сотрудников переполнен");
        }
        if ((employees.contains(employee))) {
            throw new EmployeeAlreadyAddedException("Такой сотрудник уже есть");
        }
        employees.add(employee);
    }

    @Override
    public void removeEmployee(Employee employee) {
        if (employees.contains(employee)) {
            employees.remove(employee);
        } else throw new EmployeeNotFoundException("Сотрудник не найден");
    }

    @Override
    public String findEmployee(Employee employee) {
        String text;
        if (employees.contains(employee)) {
            text = employee.toString();
        } else throw new EmployeeNotFoundException("Сотрудник не найден");
        return text;
    }

    @Override
    public String getEmployee(Integer num) {
        final Employee employee;
        employee = employees.get(num);
        final String employeeString = ""
                + employee.getFirstName() + ""
                + employee.getLastName();
        return employeeString;
    }
}

