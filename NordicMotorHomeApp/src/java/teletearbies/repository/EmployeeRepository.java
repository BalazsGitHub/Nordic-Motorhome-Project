package teletearbies.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import teletearbies.entity.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
}
