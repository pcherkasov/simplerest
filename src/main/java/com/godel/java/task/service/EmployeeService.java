package com.godel.java.task.service;

import com.godel.java.task.dao.EmployeeDao;
import com.godel.java.task.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Class EmployeeService.
 * create 15.04.2019.
 *
 * @author Pavel Cherkasov
 */

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    public List<Employee> findAll() {
        return employeeDao.findAll();
    }

    public Employee findById(int id) {
        return employeeDao.find(id);
    }

    public void sddNewEmployee(Employee model) {
        employeeDao.save(model);
    }

    public void deleteEmployee (int id) {
        employeeDao.delete(id);
    }

    public void updateEmployee (Employee model) {
        employeeDao.update(model);
    }
}
