package com.example.TrainingModuleManagement.TrainigRepo;

import com.example.TrainingModuleManagement.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpRepo extends JpaRepository<Employee,Long>{
}
