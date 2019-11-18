package com.innovect.timesheet.controller;

import com.innovect.timesheet.model.Employee;
import com.innovect.timesheet.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

  @Autowired
  private EmployeeService employeeService;

  @GetMapping("/init")
  public void init(){
    employeeService.init();
  }

  @GetMapping("/getAll")
  public Iterable<Employee> getAll()
  {
    return employeeService.getAll();
  }

  @PostMapping("/insert")
  public void insertEmployee(@RequestBody List<Employee> employeeList){
    employeeService.insertEmployee(employeeList);
  }

  @GetMapping("/employee/findById/{id}")
  public Employee findById(@PathVariable Integer id)
  {
    return employeeService.findById(id);
  }
}
