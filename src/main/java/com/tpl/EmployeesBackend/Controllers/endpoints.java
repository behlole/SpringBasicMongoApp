package com.tpl.EmployeesBackend.Controllers;

import com.mongodb.client.result.DeleteResult;
import com.tpl.EmployeesBackend.Models.Employee;
import com.tpl.EmployeesBackend.Repo.EndpointsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController()
@RequestMapping("/emp")
@CrossOrigin("*")
public class endpoints {
    @Autowired
    EndpointsRepo endpointsRepo;

    @PostMapping("/add")
    public ResponseEntity<?> test(@RequestBody Employee emp ,@PathVariable Integer empId ){
        Employee employee = endpointsRepo.insert(emp);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @DeleteMapping("/del/{empId}")
    public ResponseEntity<?> delete(@PathVariable Integer empId ){
        DeleteResult result = endpointsRepo.delete(empId);
       return new ResponseEntity<>(result,HttpStatus.OK);
    }

    @GetMapping("/getemp/{empId}")
    public ResponseEntity<?> getEmpById(@PathVariable Integer empId ){
        Employee employee = endpointsRepo.getEmpById(empId);
        return new ResponseEntity<>(employee,HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody Employee employee){
        var name = 123;
        List<Employee> emp = new ArrayList<>();
        HashMap<String,String> emp2 = new HashMap<>();

        var emp1 = emp2;
        emp1.get(3);

//        var emp2 = emp1 + "asda";
        System.out.println(emp2);
    String response = endpointsRepo.update(employee);
    return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @GetMapping("/getemployees")
    public ResponseEntity<?> get(){
        return new ResponseEntity<>(endpointsRepo.getAllEmp(),HttpStatus.OK);
    }
}
