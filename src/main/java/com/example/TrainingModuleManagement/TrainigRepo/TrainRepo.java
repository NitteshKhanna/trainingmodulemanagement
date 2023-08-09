package com.example.TrainingModuleManagement.TrainigRepo;

import com.example.TrainingModuleManagement.Entity.TrainingModule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TrainRepo extends JpaRepository<TrainingModule,Long> {
}
