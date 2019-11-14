package com.innovect.timesheet.service;

import com.innovect.timesheet.model.Project;
import com.innovect.timesheet.model.Timesheet;
import com.innovect.timesheet.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

  @Autowired
  private ProjectRepository projectRepository;

  public void getProjectCost(Integer id){
    Optional<Project> temp=projectRepository.findById(1);
    System.out.println(temp.get());
    Integer hours=0;
    Double getWage=temp.get().getCostCenter().getPerHourWage();
    if(temp.isPresent())
    {
      List<Timesheet> listOfTimesheets=temp.get().getTimesheets();
      for(Timesheet t:listOfTimesheets)
      {
        hours+=t.getHours();
      }
      System.out.println(hours*getWage);
    }else{
      System.out.println("Null -----------------------------------------------------------------------Null");
    }

  }

}
