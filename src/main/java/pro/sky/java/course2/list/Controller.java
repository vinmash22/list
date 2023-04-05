package pro.sky.java.course2.list;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class Controller {
    private final Service service;

    public Controller(Service service) {
        this.service = service;
    }

    @GetMapping()
    public String employee(@RequestParam("number") Integer num) {
        final String employee;
        employee = service.getEmployee(num);
        return employee;
    }

    @GetMapping("add")
    public String addEmployee(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        Employee employee = new Employee(firstName, lastName);
        try {
            service.addEmployee(employee);
            return "Добавлен новый сотрудник  " + firstName + " " + lastName;
        } catch (EmployeeStorageIsFullException e) {
            return "ArrayIsFull";
        } catch (EmployeeAlreadyAddedException e) {
            return "EmployeeAlreadyAdded";
        }
    }

    @GetMapping("remove")
    public String removeEmployee(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        Employee employee = new Employee(firstName, lastName);
        try {
            service.removeEmployee(employee);
            return "Удален сотрудник  " + employee;
        } catch (EmployeeNotFoundException e) {
            return "EmployeeNotFound";
        }
    }

    @GetMapping("find")
    public String findEmployee(@RequestParam("firstName") String firstName, @RequestParam("lastName") String
            lastName) {
        Employee employee = new Employee(firstName, lastName);
        try {
            service.findEmployee(employee);
            return "Найден сотрудник  " + firstName + " " + lastName;
        } catch (EmployeeNotFoundException e) {
            return "EmployeeNotFound";
        }
    }
}
