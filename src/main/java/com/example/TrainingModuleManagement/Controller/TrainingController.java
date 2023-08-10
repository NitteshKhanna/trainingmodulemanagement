package com.example.TrainingModuleManagement.Controller;

import com.example.TrainingModuleManagement.Entity.Employee;
import com.example.TrainingModuleManagement.Entity.TrainingModule;
import com.example.TrainingModuleManagement.Service.TrainServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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
    @GetMapping("/viewmodules")
    public ResponseEntity<List<TrainingModule>> viewModules() {
        List<TrainingModule> mod=trs.viewModule();
        return ResponseEntity.ok(mod);
    }
    @GetMapping("/viewmodules/{id}")
    public TrainingModule viewById(@PathVariable Long id){
        return trs.getById(id);
    }
    @PutMapping("/updateEmp/{emp_id}")
    public void updateE(@PathVariable Long emp_id,@RequestBody Employee em){trs.updateEmployee(emp_id,em);}

    @PutMapping("/updateTr/{tr_id}")
    public  void updateTrModule(@PathVariable Long tr_id, @RequestBody TrainingModule trMod){trs.updateTrModule(tr_id,trMod);}

    @DeleteMapping("/deleteEmp/{emp_id}")
    public void deleteE(@PathVariable Long emp_id,@RequestBody Employee em){trs.deleteEmployee(emp_id,em);}

    @DeleteMapping("/deleteTr/{tr_id}")
    public void deleteTrModule(@PathVariable Long tr_id,@RequestBody TrainingModule trMod){trs.deleteTrModule(tr_id, trMod);}
}
