package com.innovect.timesheet.repository;

import com.innovect.timesheet.model.Timesheet;
import org.springframework.data.repository.CrudRepository;

public interface TimesheetRepository extends CrudRepository<Timesheet,Integer> {
}
