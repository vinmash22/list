package pro.sky.java.course2.list;

import java.util.Objects;

public class Employee {
    private final String firstName;
    private final String lastName;
    private int department;
    private double salary;
    public static int idCounter;
    private int id;

    public Employee(String firstName, String lastName, int department, double salary)  {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.salary = salary;
        idCounter++;
        this.id = idCounter;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public int getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }

    @Override
    public String toString() {
        return firstName + lastName;
    }
}
