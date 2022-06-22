package com.tpl.EmployeesBackend.Repo;

import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import com.tpl.EmployeesBackend.Models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.core.query.UpdateDefinition;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EndpointsRepo {

    @Autowired
    MongoTemplate mongoTemplate;

    public Employee insert(Employee employee){
        Employee emp = mongoTemplate.insert(employee);
        return emp;
    }

    public DeleteResult delete(Integer empId){
        Query query = new Query();
        query.addCriteria(Criteria.where("employeeId").is(empId));
        DeleteResult employee = mongoTemplate.remove(query,"employee");
        return employee;
    }
    public Employee getEmpById(Integer empId){
        Query query = new Query();
        query.addCriteria(Criteria.where("employeeId").is(empId));
        Employee employee = mongoTemplate.findOne(query,Employee.class);
        return employee;
    }

    public List<Employee> getAllEmp(){
        return mongoTemplate.findAll(Employee.class);
    }
    public String update(Employee employee){
        Query query = new Query();
        query.addCriteria(Criteria.where("employeeId").is(employee.getEmployeeId()));
        Update update = new Update();
        update.set("name",employee.getName());
        update.set("employeeId",employee.getEmployeeId());
        update.set("age",employee.getAge());
        UpdateResult updateResult = mongoTemplate.updateFirst(query,update,Employee.class);
        if(updateResult.getMatchedCount()!=0){
            return "record updated";
        }
        else {
            return "record is not updated!";
        }
    }


}
