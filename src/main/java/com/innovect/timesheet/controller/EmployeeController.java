package com.innovect.timesheet.controller;

import com.innovect.timesheet.model.Employee;
import com.innovect.timesheet.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

  @Autowired
  private EmployeeService employeeService;

  @GetMapping("/init")
  public void init(){
    employeeService.init();
  }

  @GetMapping("/getAll")
  private Iterable<Employee> getAll()
  {
    return employeeService.getAll();
  }
}
