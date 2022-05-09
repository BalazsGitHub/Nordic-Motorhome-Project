package teletearbies.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import teletearbies.entity.Employee;
import teletearbies.repository.EmployeeRepository;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public Employee findById(int id) {
        return employeeRepository.findById(id).get();
    }

    public List<Employee> getAllEmployees() {
        return (List<Employee>) employeeRepository.findAll();
    }

}