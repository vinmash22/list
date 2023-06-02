package pro.sky.java.course2.list;

import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceTest {

    EmployeeService service = new EmployeeService();

    @Test
    void addEmployeeTest() {
        Employee expected = new Employee("Иван", "Иванов", 1, 50000);
        Employee actual = service.addEmployee("иван", "иванов", 1, 50000);
        assertEquals(expected, actual);
    }

    @Test
    void employeeAlreadyAddedTest() {
        service.addEmployee("иван", "иванов", 1, 50000);
        assertThrows(EmployeeAlreadyAddedException.class, () -> service.addEmployee("иван", "иванов", 1, 50000));
    }

    @Test
    void employeeStorageIsFullExceptionTest() {
        service.addEmployee("иван", "иванов", 1, 50000);
        service.addEmployee("ивана", "иванова", 1, 50000);
        service.addEmployee("иванб", "ивановб", 1, 50000);
        service.addEmployee("иванв", "ивановв", 1, 50000);
        service.addEmployee("иванг", "ивановг", 1, 50000);
        service.addEmployee("иванд", "ивановд", 1, 50000);
        service.addEmployee("иване", "иванове", 1, 50000);
        service.addEmployee("иванж", "ивановж", 1, 50000);
        service.addEmployee("иванз", "ивановз", 1, 50000);
        service.addEmployee("ивани", "иванови", 1, 50000);
        assertThrows(EmployeeStorageIsFullException.class, () -> service.addEmployee("иванк", "ивановк", 1, 50000));
    }

    @Test
    void invalidDataExceptionTest() {
        assertThrows(InvalidDataException.class, () -> service.addEmployee("иван1", "иванов", 1, 50000));
        assertThrows(InvalidDataException.class, () -> service.addEmployee("иван1", "иванов1", 1, 50000));
        assertThrows(InvalidDataException.class, () -> service.addEmployee("иван", "иванов1", 1, 50000));
    }

    @Test
    void removeEmployee() {
        Employee employee = new Employee("Иван", "Иванов", 1, 50000);
        service.addEmployee("иван", "иванов", 1, 50000);
        assertEquals(1, service.findAll().size());
        assertEquals(employee, service.findAll().iterator().next());

        service.removeEmployee("иван", "иванов", 1, 50000);
        assertEquals(0, service.findAll().size());
        assertThrows(EmployeeNotFoundException.class, () -> service.removeEmployee("Иванa", "Ивановa", 1, 50000));

    }

    @Test
    void findEmployee() {
        Employee employee = new Employee("Иван", "Иванов", 1, 50000);
        service.addEmployee("иван", "иванов", 1, 50000);
        service.addEmployee("петр", "петров", 2, 55000);
        assertEquals(employee, service.findEmployee("иван", "иванов", 1, 50000));
        assertEquals(employee, service.findEmployee("Иван", "Иванов", 1, 50000));
        assertThrows(EmployeeNotFoundException.class, () -> service.findEmployee("Иванa", "Ивановa", 1, 50000));
    }

    @Test
    void findAllTest() {
        service.addEmployee("иван", "иванов", 1, 50000);
        service.addEmployee("петр", "петров", 2, 55000);
        Collection<Employee> employees = service.findAll();

        assertEquals(2, employees.size());

        List<Employee> expected = List.of(

                new Employee("Петр", "Петров", 2, 55000),
                new Employee("Иван", "Иванов", 1, 50000));

        assertIterableEquals(expected, employees);
    }

    @Test
    void findAllIsEmpty() {
        assertEquals(0, service.findAll().size());
    }
}