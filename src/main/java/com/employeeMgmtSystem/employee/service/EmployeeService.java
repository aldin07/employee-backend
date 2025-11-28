package com.employeeMgmtSystem.employee.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.employeeMgmtSystem.employee.entity.Employee;
import com.employeeMgmtSystem.employee.repository.EmployeeRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service                
@RequiredArgsConstructor          
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public Employee postEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    public void deleteEmployee(Long id){
        if(!employeeRepository.existsById(id)){
            throw new EntityNotFoundException("Employee with ID " + id + " not found");
        }

        employeeRepository.deleteById(id);
    }
}
