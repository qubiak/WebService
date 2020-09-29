package pl.WebService.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.WebService.Repository.EmployeeRepository;
import pl.WebService.Model.Employee;
import pl.WebService.Repository.FindByNameRepository;

@Controller
public class MainController {

    @Autowired
    public EmployeeRepository employeeRepository;
    @Autowired
    public FindByNameRepository findByNameRepository;
    StringBuilder response = new StringBuilder();

    @RequestMapping("/addEmployee")
    @ResponseBody
    public String addEmployee() {

        Employee task = new Employee()
                .withName("Bartomiej")
                .withSurname("Kubiak")
                .withSalary(4200);
        employeeRepository.save(task);

        Employee task2 = new Employee()
                .withName("Adam")
                .withSurname("Nowak")
                .withSalary(4200);
        employeeRepository.save(task2);
        seeEmployee();

        return response.toString();
    }

    @RequestMapping("/seeEmployee")
    @ResponseBody
    public String seeEmployee() {
        for (Employee i : employeeRepository.findAll()) {
            response.append(i).append("<br>");
        }

        return response.toString();
    }

    @RequestMapping("/delateAll")
    @ResponseBody
    public String delateAll() {

        employeeRepository.deleteAll();
        seeEmployee();

        return response.toString();
    }

    @RequestMapping("/delateById")
    @ResponseBody
    public String delateById(@RequestParam("id")Long id) {
    //  http://localhost:8080/delateById?id=17
        employeeRepository.deleteById(id);
        seeEmployee();

        return response.toString();
    }

    @RequestMapping("/findByName")
    @ResponseBody
    public String findByName(@RequestParam("name")String name) {
    //  http://localhost:8080/findByName?name=Adam
        response.append("Task with " + name + " in name:\n");

        for (Employee i : findByNameRepository.findByName(name)) {
            response.append(i).append("<br>");
        }
        return response.toString();
    }
}