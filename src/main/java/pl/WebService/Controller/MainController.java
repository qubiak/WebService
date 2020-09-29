package pl.WebService.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.WebService.Repository.EmployeeRepository;
import pl.WebService.Model.Employee;
import pl.WebService.Repository.FindByNameRepository;

@Controller
public class MainController {

    @Autowired
    public EmployeeRepository employeeRepository;
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

    @RequestMapping("/delateById/{IDtoDelate}")
    @ResponseBody
    public String delateById() {

        Long IDtoDelate = null;
        employeeRepository.deleteById(IDtoDelate);
        seeEmployee();

        return response.toString();
    }

    @RequestMapping("/searchByName")
    @ResponseBody
    public String searchByName() {

        response.append("Task with \"Adam\" in name:\n");

        for (Employee i : FindByNameRepository.findByNameRepository.findByName("Adam")){
            response.append(i).append("<br>");
        }
        return response.toString();
    }
}