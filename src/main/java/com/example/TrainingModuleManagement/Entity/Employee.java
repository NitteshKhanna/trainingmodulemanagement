package com.example.TrainingModuleManagement.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.*;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int emp_id;

    private String emp_name;

    private String emp_email;

    @ManyToMany
    @JoinTable(name = "employee_training",joinColumns = @JoinColumn(name = "employee_id"),inverseJoinColumns = @JoinColumn(name = "training_id"))
    @JsonBackReference
    private Set<TrainingModule> trainingModules=new HashSet<>();

    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public String getEmp_email() {
        return emp_email;
    }

    public void setEmp_email(String emp_email) {
        this.emp_email = emp_email;
    }

    public Set<TrainingModule> getTrainingModules() {
        return trainingModules;
    }

    public void setTrainingModules(Set<TrainingModule> trainingModules) {
        this.trainingModules = trainingModules;
    }
}
