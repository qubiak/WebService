package pl.WebService;

import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository<employee> extends CrudRepository<employee, Long> {

}
