package com.innovect.timesheet.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
property = "timesheetId")
public class Timesheet {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="timesheet_id")
  private Integer timesheetId;
  @Temporal(TemporalType.DATE)
  private Date date;
  private Integer hours;
  @ManyToOne
  @JoinColumn(name="project_id")
  private Project project;
  @ManyToOne
  @JoinColumn(name = "employee_id")
  private Employee employee;

  public Timesheet() {
  }

  public Timesheet(Date date, Integer hours) {
    this.date = date;
    this.hours = hours;
  }

  public Integer getTimesheetId() {
    return timesheetId;
  }

  public void setTimesheetId(Integer timesheetId) {
    this.timesheetId = timesheetId;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public Integer getHours() {
    return hours;
  }


  public void setHours(Integer hours) {
    this.hours = hours;
  }

  public Project getProject() {
    return project;
  }

  public void setProject(Project project) {
    this.project = project;
  }
  public Employee getEmployee() {
    return employee;
  }

  public void setEmployee(Employee employee) {
    this.employee = employee;
  }
}
