package pro.sky.java.course2.list;

import org.springframework.web.bind.annotation.*;

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

    @GetMapping("{id}/max-salary")
    public Employee findEmployeeWithMaxSalaryByDepartment(@PathVariable int id) {
        return departmentService.findEmployeeWithMaxSalaryByDepartment(id);
    }

    @GetMapping("{id}/min-salary")
    public Employee findEmployeeWithMinSalaryByDepartment(@PathVariable int id) {
        return departmentService.findEmployeeWithMinSalaryByDepartment(id);
    }

    @GetMapping(value=  "{id}/employees", params = {"id"})
    public Collection<Employee> allEmployeesByDepartment(@PathVariable int id) {
        return departmentService.allEmployeesByDepartment(id);
    }

    @GetMapping("employees")
    public Map<Integer, List<Employee>> allEmployeesByDepartments() {
        return departmentService.allEmployeesByDepartments();
    }


}
