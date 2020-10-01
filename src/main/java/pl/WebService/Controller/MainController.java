package pl.WebService.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.WebService.Repository.EmployeeRepository;
import pl.WebService.Model.Employee;

@Controller
public class MainController {

    @Autowired
    public EmployeeRepository employeeRepository;
    StringBuilder response = new StringBuilder();

    @RequestMapping("/addEmployee")
    @ResponseBody
    public String addEmployee(
            //  http://localhost:8080/addEmployee?name=Adam&surname=Nowak&salary=1500
            @RequestParam("name") String name,
            @RequestParam("surname") String surname,
            @RequestParam("salary") Long salary) {

        Employee task = new Employee()
                .withName(name)
                .withSurname(surname)
                .withSalary(salary);
        employeeRepository.save(task);
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

        return response.toString();
    }

    @RequestMapping("/delateById")
    @ResponseBody
    public String delateById(@RequestParam("id") Long id) {
        //  http://localhost:8080/delateById?id=17
        employeeRepository.deleteById(id);
        seeEmployee();

        return response.toString();
    }

    @RequestMapping("/findByName")
    @ResponseBody
    public String findByName(@RequestParam("name") String name) {
        //  http://localhost:8080/findByName?name=Adam
        response.append("Task with " + name + " in name:\n");

        for (Employee i : employeeRepository.findByName(name)) {
            response.append(i).append("<br>");
        }
        return response.toString();
    }
}