package pl.WebService.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.WebService.Model.Employee;

import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    public List<Employee> findByName(String name);

    @Query("select t from Employee t where t.name like %?1%")
    public List<Employee> getName(String name);
}