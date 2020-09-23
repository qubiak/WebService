package pl.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.WebService.Model.employee;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    public EmployeeRepository employeeRepository;

    @RequestMapping("/db")
    @ResponseBody
    public String testMethod() {
        StringBuilder response = new StringBuilder();

        employee task = new employee()
                .withName("Bartomiej1")
                .withSurname("Kubiak")
                .withSalary(4200);
        employeeRepository.save(task);

        for(employee i: employeeRepository.findAll()) {
            response.append(i).append("<br>");
        }

        return response.toString();
    }
}