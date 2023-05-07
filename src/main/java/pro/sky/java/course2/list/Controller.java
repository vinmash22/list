package pro.sky.java.course2.list;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;


@RestController
@RequestMapping("/employee")
public class Controller {
    private final Service service;

    public Controller(Service service) {
        this.service = service;
    }

    @GetMapping("add")
    public Employee addEmployee(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName,
                                @RequestParam("department") int department, @RequestParam("salary") double salary) {
        return service.addEmployee(firstName, lastName, department, salary);
    }

    @GetMapping("remove")
    public Employee removeEmployee(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName,
                                   @RequestParam("department") int department, @RequestParam("salary") double salary) {
        return service.removeEmployee(firstName, lastName, department, salary);
    }

    @GetMapping("find")
    public Employee findEmployee(@RequestParam("firstName") String firstName, @RequestParam("lastName") String
            lastName, @RequestParam("department") int department, @RequestParam("salary") double salary) {
        return service.findEmployee(firstName, lastName, department, salary);
    }

    @GetMapping("list")
    public Collection<Employee> findAll() {
        return service.findAll();
    }

}
