package com.innovect.timesheet.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.Entity;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
property="id")
public class Employee {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String name;
  private Integer managerId;
  private String email;
  private String mobileNumber;

  @ManyToMany(mappedBy="employees",cascade = CascadeType.ALL)
  private List<Project> projects;

  @OneToMany(mappedBy = "employee",cascade = CascadeType.ALL)
  private List<Timesheet> timesheets;

  public Employee() {
  }

  public Employee(String name, Integer managerId, String email, String mobileNumber, List<Project> projects) {
    this.name = name;
    this.managerId = managerId;
    this.email = email;
    this.mobileNumber = mobileNumber;
    this.projects = projects;
  }

  public List<Timesheet> getTimesheets() {
    return timesheets;
  }

  public void setTimesheets(List<Timesheet> timesheets) {
    this.timesheets = timesheets;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getManagerId() {
    return managerId;
  }

  public void setManagerId(Integer managerId) {
    this.managerId = managerId;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getMobileNumber() {
    return mobileNumber;
  }

  public void setMobileNumber(String mobileNumber) {
    this.mobileNumber = mobileNumber;
  }
  public void addProject(Project project){
    if(projects==null){
      projects=new ArrayList<Project>();
    }
    projects.add(project);
  }

  public List<Project> getProjects() {
    return projects;
  }

  public void setProjects(List<Project> projects) {
    this.projects = projects;
  }

  @Override
  public String toString() {
    return "Employee{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", managerId=" + managerId +
        ", email='" + email + '\'' +
        ", mobileNumber='" + mobileNumber + '\'' +
        ", projects=" + projects +
        '}';
  }
}
