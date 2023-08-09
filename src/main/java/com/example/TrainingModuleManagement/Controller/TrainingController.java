package com.example.TrainingModuleManagement.Controller;

import com.example.TrainingModuleManagement.Entity.Employee;
import com.example.TrainingModuleManagement.Entity.TrainingModule;
import com.example.TrainingModuleManagement.Service.TrainServ;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class TrainingController {
    @Autowired
    TrainServ trs;
    @PostMapping("/create")
    public TrainingModule saveT(@RequestBody TrainingModule tr){
      return trs.saveTrain(tr);
    }

    @PostMapping("/createemp")
    public Employee saveE(@RequestBody Employee em){
        return trs.saveEmp(em);
    }
    @PostMapping("/assignmodule")
    public void assignModule(@RequestParam Long mId,@RequestParam Long empId){
        trs.assingModule(mId,empId);
    }
}
