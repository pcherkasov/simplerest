package com.godel.java.task.dao;

import com.godel.java.task.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.util.List;

/**
 * Class EmployeeDaoSpringJdbcImpl.
 * create 29.04.2019.
 *
 * @author Pavel Cherkasov
 */

@Repository
public class EmployeeDaoSpringJdbcImpl implements EmployeeDao {

    private static final String SELECT_ALL = "SELECT * FROM employee ORDER BY employee_id";
    private static final String SELECT_BY_ID = "SELECT * FROM employee WHERE employee_id = ?";
    private static final String INSERT_NEW_EMPLOYEE = "INSERT INTO employee (first_name, gender) VALUES (?, ?)";
    private static final String UPDATE_EMPLOYEE = "UPDATE employee SET first_name = ?, last_name = ?, department_id = ?, job_title = ?, gender = ?, date_of_birdth = ? WHERE ? = employee_id";
    private static final String DELETE_EMPLOYEE = "DELETE FROM employee WHERE employee_id = ?";


    private JdbcTemplate jdbcTemplate;

    @Autowired
    public EmployeeDaoSpringJdbcImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private RowMapper<Employee> employeeRowMapper
            = (ResultSet resultSet, int i) -> {
        Employee employee = new Employee();
        employee.setEmployeeId(resultSet.getInt("employee_id"));
        employee.setFirstName(resultSet.getString("first_name"));
        employee.setGender(resultSet.getString("gender"));
      return employee;
    };


    @Override
    public Employee find(Integer id) {
        return jdbcTemplate.queryForObject(SELECT_BY_ID, new Object[]{id}, employeeRowMapper);
    }

    @Override
    public void save(Employee model) {
        jdbcTemplate.update(INSERT_NEW_EMPLOYEE, model.getFirstName(), model.getGender().toString());
    }

    @Override
    public void update(Employee model) {
        jdbcTemplate.update(UPDATE_EMPLOYEE, model.getFirstName(), null, null, null, model.getGender().toString(), null, model.getEmployeeId());
    }

    @Override
    public void delete(Integer id) {
        jdbcTemplate.update(DELETE_EMPLOYEE, id);
    }

    @Override
    public List<Employee> findAll() {
        return jdbcTemplate.query(SELECT_ALL, employeeRowMapper);
    }
}
