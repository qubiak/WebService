package pl.WebService.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.scheduling.config.Task;

import java.util.List;

public interface FindByNameRepository extends CrudRepository<Task, Long> {

    public List findByDone(Boolean done);

    @Query("select t from Employee t where t.Name like %?1%")
    public List getByDescriptionLike(String search);

    @Autowired
    public FindByNameRepository findByNameRepository = null;
}




