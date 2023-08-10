package com.example.TrainingModuleManagement.Service;

import com.example.TrainingModuleManagement.Entity.Employee;
import com.example.TrainingModuleManagement.Entity.TrainingModule;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.*;

public interface TrainServInt {
    public TrainingModule saveTrain(TrainingModule tr);
    public Employee saveEmp(Employee emp);
    public void assingModule(Long mId,Long empId);
    public List<TrainingModule> viewModule();
    public TrainingModule getById(Long id);
    public void updateEmployee(@PathVariable Long emp_id, @RequestBody Employee employeeDetails);

    public void updateTrModule(@PathVariable Long tr_id, @RequestBody TrainingModule trModuleDetails);

    public void deleteEmployee(@PathVariable Long emp_id , @RequestBody Employee employeeDetails);

    public void deleteTrModule(@PathVariable Long tr_id, @RequestBody TrainingModule trMod);


}
