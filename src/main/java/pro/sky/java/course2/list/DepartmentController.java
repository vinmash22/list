package pro.sky.java.course2.list;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("max-salary")
    public Employee findEmployeeWithMaxSalaryByDepartment(@RequestParam("departmentId") int department) {
        return departmentService.findEmployeeWithMaxSalaryByDepartment(department);
    }

    @GetMapping("min-salary")
    public Employee findEmployeeWithMinSalaryByDepartment(@RequestParam("departmentId") int department) {
        return departmentService.findEmployeeWithMinSalaryByDepartment(department);
    }

    @GetMapping(value="all", params = {"departmentId"})
    public Collection<Employee> allEmployeesByDepartment(@RequestParam("departmentId") int department) {
        return departmentService.allEmployeesByDepartment(department);
    }

    @GetMapping("all")
    public Map<Integer, List<Employee>> allEmployeesByDepartments() {
        return departmentService.allEmployeesByDepartments();
    }


}
