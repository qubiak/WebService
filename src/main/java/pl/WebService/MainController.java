package pl.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.WebService.Model.Employee;


@Controller
//@org.springframework.stereotype.Controller
public class MainController {

    @Autowired
    public EmployeeRepository employeeRepository;

    @RequestMapping("/db")
    @ResponseBody
    public String testMethod() {
        StringBuilder response = new StringBuilder();

        Employee task = new Employee()
                .withName("Bartomiej1")
                .withSurname("Kubiak")
                .withSalary(4200);
        employeeRepository.save(task);

            for (Employee i : employeeRepository.findAll()) {
                response.append(i).append("<br>");
            }

        return response.toString();
    }
}
