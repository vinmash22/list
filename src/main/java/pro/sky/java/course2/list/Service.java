package pro.sky.java.course2.list;

public interface Service {


    void addEmployee(Employee employee);

    void removeEmployee(Employee employee);

    String findEmployee(Employee employee);

    String getEmployee(Integer num);

}
