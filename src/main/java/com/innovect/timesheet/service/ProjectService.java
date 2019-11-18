package com.innovect.timesheet.service;

import com.innovect.timesheet.model.Project;
import com.innovect.timesheet.model.Timesheet;
import com.innovect.timesheet.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProjectService {

  @Autowired
  private ProjectRepository projectRepository;

  public Double getProjectCost(Integer id){
    Optional<Project> temp=projectRepository.findById(1);
    System.out.println(temp.get());
    Integer hours=temp.get().getTimesheets().stream().collect(Collectors.summingInt(Timesheet::getHours));
    Double getWage=temp.get().getCostCenter().getPerHourWage();
    return hours*getWage;
  }

}
