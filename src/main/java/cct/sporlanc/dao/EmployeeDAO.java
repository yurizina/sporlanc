package cct.sporlanc.dao;

import java.util.List;

import cct.sporlanc.model.Employee;

public interface EmployeeDAO {

	public void saveOrUpdate(Employee employee);

	public void delete(int emp_id);

	public Employee getEmployee(int emp_id);

	public List<Employee> list();

}
