package com.example.TrainingModuleManagement.Service;

import com.example.TrainingModuleManagement.Entity.Employee;
import com.example.TrainingModuleManagement.Entity.TrainingModule;

import java.util.*;

public interface TrainServInt {
    public TrainingModule saveTrain(TrainingModule tr);
    public Employee saveEmp(Employee emp);
    public void assingModule(Long mId,Long empId);
    public List<TrainingModule> viewModule();
    public TrainingModule getById(Long id);
}
