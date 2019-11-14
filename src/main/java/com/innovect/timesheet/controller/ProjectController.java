package com.innovect.timesheet.controller;

import com.innovect.timesheet.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProjectController {
  @Autowired
  private ProjectService projectService;

  @GetMapping("/GetCost/{id}")
  public void getProjectCost(@PathVariable("id") Integer id){
     projectService.getProjectCost(id);

  }
}
