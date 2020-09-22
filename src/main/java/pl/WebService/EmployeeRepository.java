package pl.WebService;

import org.springframework.data.repository.CrudRepository;
import pl.WebService.Model.employee;

public interface EmployeeRepository extends CrudRepository<employee, Long> {
}
