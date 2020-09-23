package pl.WebService;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.WebService.Model.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}