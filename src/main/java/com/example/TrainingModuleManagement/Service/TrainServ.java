package com.example.TrainingModuleManagement.Service;

import com.example.TrainingModuleManagement.Entity.Employee;
import com.example.TrainingModuleManagement.Entity.TrainingModule;
import com.example.TrainingModuleManagement.Exception.ResourceNotFoundException;
import com.example.TrainingModuleManagement.TrainigRepo.EmpRepo;
import com.example.TrainingModuleManagement.TrainigRepo.TrainRepo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

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
    @Override
    public void updateEmployee(@PathVariable Long emp_id, @RequestBody Employee employeeDetails){
        Employee employee = e.findById(emp_id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + emp_id)) ;
        employee.setEmp_name(employeeDetails.getEmp_name());
        employee.setEmp_email((employeeDetails.getEmp_email()));
        e.save(employee);
    }

    @Override
    public void updateTrModule(@PathVariable Long tr_id, @RequestBody TrainingModule trModuleDetails){
        TrainingModule tmod = t.findById(tr_id)
                .orElseThrow(() -> new ResourceNotFoundException("Training Module not found with id:"+tr_id));
        tmod.setTr_name(trModuleDetails.getTr_name());
        tmod.setDescription(trModuleDetails.getDescription());
        tmod.setT1(trModuleDetails.getT1());
        tmod.setT2(trModuleDetails.getT2());
        tmod.setT3(trModuleDetails.getT3());
        tmod.setT4(trModuleDetails.getT4());
        t.save(tmod);
    }

    @Override
    public void deleteEmployee(@PathVariable Long emp_id,@RequestBody Employee employeeDetails){
        Employee employee = e.findById(emp_id)

                .orElseThrow(()-> new ResourceNotFoundException("Employee not found with id:"+emp_id));
        e.delete(employee);
    }

    @Override
    public void deleteTrModule(@PathVariable Long tr_id,@RequestBody TrainingModule trModuleDetails){
        TrainingModule trmod = t.findById(tr_id)
                .orElseThrow(()-> new ResourceNotFoundException("Training module not found with id:"+tr_id));
        t.delete(trmod);
    }

}
