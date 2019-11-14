package com.innovect.timesheet.service;

import com.innovect.timesheet.model.CostCenter;
import com.innovect.timesheet.model.Employee;
import com.innovect.timesheet.model.Project;
import com.innovect.timesheet.model.Timesheet;
import com.innovect.timesheet.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class EmployeeService {
  @Autowired
  private EmployeeRepository employeeRepository;

  public Iterable<Employee> getAll()
  {
    return  employeeRepository.findAll();
  }

  public void init() {
    List<Project> project1=new ArrayList<>();
    List<Project> project2=new ArrayList<>();

    List<Timesheet> timesheets1=new ArrayList<>();
    List <Timesheet> timesheets2=new ArrayList<>();

    Timesheet timesheet1=new Timesheet(new Date(),8);
    Timesheet timesheet2=new Timesheet(new Date(),8);
    Timesheet timesheet3=new Timesheet(new Date(),8);
    Timesheet timesheet4=new Timesheet(new Date(),8);
    Timesheet timesheet5=new Timesheet(new Date(),8);
    timesheets1.add(timesheet1);
    timesheets1.add(timesheet2);
    timesheets2.add(timesheet3);
    timesheets2.add(timesheet4);
    timesheets2.add(timesheet5);
    Project p1=new Project("abc",new CostCenter("abc",5000.0,1));
    timesheet1.setProject(p1);
    timesheet2.setProject(p1);

    p1.setTimesheets(timesheets1);
    Project p2=new Project("pqr",new CostCenter("pqr",5000.0,1));
    timesheet3.setProject(p2);
    timesheet4.setProject(p2);
    timesheet5.setProject(p2);
    p2.setTimesheets(timesheets2);
//    Project p3=new Project("sdf",new CostCenter("sdf",5000.0,1));
//    p3.setTimesheets(timesheets2);
//    Project p4=new Project("ghi",new CostCenter("ghi",5000.0,1));
//    p4.setTimesheets(timesheets2);
//    Project p5=new Project("xyz",new CostCenter("xyz",5000.0,1));
//    p5.setTimesheets(timesheets2);
    project1.add(p1);
    project2.add(p2);
//    List<Project> project2 =new ArrayList<>();
//    project2.add(p3);
//    project2.add(p4);
//    project2.add(p5);
    Employee employee1= new Employee("qwer",1,"qwer@qw","88779944",project1);
    Employee employee2= new Employee("hjkl",1,"hjkl@qw","12344112",project2);
    timesheet1.setEmployee(employee1);
    timesheet2.setEmployee(employee1);
    timesheet3.setEmployee(employee2);
    timesheet4.setEmployee(employee2);
    timesheet5.setEmployee(employee2);
    p1.addEmployee(employee1);
    p2.addEmployee(employee2);
//    p3.addEmployee(employee2);
//    p4.addEmployee(employee2);
//    p5.addEmployee(employee2);
    employeeRepository.save(employee1);
    employeeRepository.save(employee2);
  }
}
