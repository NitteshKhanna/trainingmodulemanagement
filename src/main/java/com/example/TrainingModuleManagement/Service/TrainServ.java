package com.example.TrainingModuleManagement.Service;

import com.example.TrainingModuleManagement.Entity.Employee;
import com.example.TrainingModuleManagement.Entity.TrainingModule;
import com.example.TrainingModuleManagement.TrainigRepo.EmpRepo;
import com.example.TrainingModuleManagement.TrainigRepo.TrainRepo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrainServ implements TrainServInt {
    @Autowired
    TrainRepo t;

    @Autowired
    EmpRepo e;

    @Override
    public TrainingModule saveTrain(TrainingModule tr) {
        return t.save(tr);
    }

    @Override
    public Employee saveEmp(Employee em) {
        return e.save(em);
    }

    @Override
    public void assingModule(Long mId, Long empId) {
        TrainingModule trmo=t.findById(mId).orElse(null);
        Employee emp=e.findById(empId).orElse(null);
        if(trmo!=null && emp!=null){
            emp.getTrainingModules().add(trmo);
            e.save(emp);
        }
    }

    @Override
    public List<TrainingModule> viewModule() {
        return t.findAll();
    }

    @Override
    public TrainingModule getById(Long id) {
        Optional<TrainingModule> trmod=t.findById(id);
        return trmod.get();
    }


}
