package com.innovect.timesheet.model;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
property="projectId")
public class Project {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer projectId;
  private String title;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name="cost_center_id")
  private CostCenter costCenter;

  @ManyToMany
  @JoinTable(name = "project_employee",
      joinColumns = @JoinColumn(name = "project_id"),
      inverseJoinColumns = @JoinColumn(name="employee_id"))
  private List<Employee> employees;

  @OneToMany(mappedBy = "project",cascade = CascadeType.ALL)
  private List<Timesheet> timesheets;

  public Project() {
  }

  public Project(String title, CostCenter costCenter) {
    this.title = title;
    this.costCenter = costCenter;
  }

  public void addTimesheet(Timesheet timesheet){
    if(timesheets==null)
    {
      timesheets=new ArrayList<>();
    }
    timesheets.add(timesheet);
  }
  public void addEmployee(Employee employee)
  {
    if(employees==null){
      employees=new ArrayList<Employee>();
    }
    employees.add(employee);
  }
  public Integer getProjectId() {
    return projectId;
  }

  public void setProjectId(Integer projectId) {
    this.projectId = projectId;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public CostCenter getCostCenter() {
    return costCenter;
  }

  public void setCostCenter(CostCenter costCenter) {
    this.costCenter = costCenter;
  }


  public List<Employee> getEmployees() {
    return employees;
  }

  @Override
  public String toString() {
    return "Project{" +
        "projectId=" + projectId +
        ", title='" + title + '\'' +
        ", costCenter=" + costCenter +
        '}';
  }

  public void setEmployees(List<Employee> employees) {
    this.employees = employees;
  }

  public List<Timesheet> getTimesheets() {
    return timesheets;
  }

  public void setTimesheets(List<Timesheet> timesheets) {
    this.timesheets = timesheets;
  }
}
