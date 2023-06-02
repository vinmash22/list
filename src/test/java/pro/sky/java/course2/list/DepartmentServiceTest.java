package pro.sky.java.course2.list;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class DepartmentServiceTest {
    @Mock
    EmployeeService employeeServiceMock;
    DepartmentService service;

    @BeforeEach
    void setup() {
        MockitoAnnotations.initMocks(this);
        service = new DepartmentService(employeeServiceMock);
    }

    @Test
    void findEmployeeWithMaxSalaryByDepartmentTest() {
        List<Employee> employees = List.of(

                new Employee("Петр", "Петров", 2, 55000),
                new Employee("Иван", "Иванов", 1, 50000),
                new Employee("Василий", "Васильев", 2, 65000));
        when(employeeServiceMock.findAll()).thenReturn(employees);
        assertNull(service.findEmployeeWithMaxSalaryByDepartment(5));
        assertEquals(employees.get(2), service.findEmployeeWithMaxSalaryByDepartment(2));
    }

    @Test
    void findEmployeeWithMinSalaryByDepartmentTest() {
        List<Employee> employees = List.of(

                new Employee("Петр", "Петров", 2, 55000),
                new Employee("Иван", "Иванов", 1, 50000),
                new Employee("Василий", "Васильев", 2, 65000));
        when(employeeServiceMock.findAll()).thenReturn(employees);
        assertNull(service.findEmployeeWithMinSalaryByDepartment(5));
        assertEquals(employees.get(0), service.findEmployeeWithMinSalaryByDepartment(2));
    }

    @Test
    void allEmployeesByDepartment() {
        List<Employee> employees = List.of(

                new Employee("Петр", "Петров", 2, 55000),
                new Employee("Иван", "Иванов", 1, 50000),
                new Employee("Василий", "Васильев", 2, 65000));
        when(employeeServiceMock.findAll()).thenReturn(employees);

        Collection<Employee> actualList = service.allEmployeesByDepartment(2);
        assertEquals(2, actualList.size());
        List<Employee> expectedList = List.of(

                new Employee("Петр", "Петров", 2, 55000),
                new Employee("Василий", "Васильев", 2, 65000));
        assertIterableEquals(expectedList, actualList);

        Collection<Employee> emptyList = service.allEmployeesByDepartment(10);
        assertEquals(0, emptyList.size());
    }

    @Test
    void allEmployeesByDepartments() {
        List<Employee> employees = List.of(

                new Employee("Петр", "Петров", 2, 55000),
                new Employee("Иван", "Иванов", 1, 50000),
                new Employee("Василий", "Васильев", 2, 65000));
        when(employeeServiceMock.findAll()).thenReturn(employees);

        Map<Integer, List<Employee>> actual = service.allEmployeesByDepartments();
        assertEquals(2, actual.size());
        assertEquals(1, actual.get(1).size());
        assertEquals(2, actual.get(2).size());
        assertEquals(new Employee("Иван", "Иванов", 1, 50000), actual.get(1).get(0));
        assertEquals(List.of(
                        new Employee("Петр", "Петров", 2, 55000),
                        new Employee("Василий", "Васильев", 2, 65000)),
                actual.get(2));
    }
}