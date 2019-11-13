package com.innovect.timesheet.repository;

import com.innovect.timesheet.model.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee,Integer> {
}
