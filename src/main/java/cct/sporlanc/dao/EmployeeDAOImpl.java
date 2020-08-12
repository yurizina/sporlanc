package cct.sporlanc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;


import cct.sporlanc.model.Employee;


public class EmployeeDAOImpl implements EmployeeDAO {

	private JdbcTemplate jdbcTemplate;

	public EmployeeDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void saveOrUpdate(Employee employee) {
		
		if (employee.getEmp_id() > 0) {
			
			//update, in this option the employee cannot change his surname, but he/she is allowed to change password! 
			String sql = "UPDATE employee SET username = ?, first_name = ?, surname = ?, gender = ?, birth_date = ?, "
					+ "staff_role = ?, phone = ?, hire_date = ?, address =?, email = ?, password = ?, eircodeID = ?"
					+ " WHERE emp_id = ? ";
			jdbcTemplate.update(sql, employee.getUsername(), employee.getFirst_name(), employee.getSurname(), employee.getGender(),
					employee.getBirth_date(), employee.getStaff_role(), employee.getPhone(),
					employee.getHire_date(), employee.getAddress(), employee.getEmail(), employee.getPassword(),
					employee.getEircodeID(), employee.getEmp_id());
		} else {
			
			String sql = "INSERT INTO employee (username, first_name, surname, gender, " + 
					"birth_date, staff_role, phone, hire_date, address, email, password, eircodeID) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
			jdbcTemplate.update(sql, employee.getUsername(), employee.getFirst_name(), employee.getSurname(), employee.getGender(),
					employee.getBirth_date(), employee.getStaff_role(), employee.getPhone(),
					employee.getHire_date(), employee.getAddress(), employee.getEmail(), employee.getPassword(),
					employee.getEircodeID());
		}
	}

	@Override
	public void delete(int emp_id) {
		String sql = "DELETE FROM employee WHERE emp_id = ?";
		jdbcTemplate.update(sql, emp_id);

	}

	@Override
	public Employee getEmployee(int emp_id) {
		String sql = "SELECT * FROM employee WHERE emp_id = " + emp_id;

		return jdbcTemplate.query(sql, new ResultSetExtractor<Employee>() {

			@Override
			public Employee extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					
					Employee employee = new Employee();
					
					employee.setEmp_id(rs.getInt("emp_id"));
					employee.setUsername(rs.getString("username"));
					employee.setFirst_name(rs.getString("first_name"));
					employee.setSurname(rs.getString("surname"));
					employee.setGender(rs.getString("gender"));
					employee.setBirth_date(rs.getString("birth_date"));
					employee.setStaff_role(rs.getString("staff_role"));
					employee.setPhone(rs.getInt("phone"));
					employee.setHire_date(rs.getString("hire_date"));
					employee.setAddress(rs.getString("address"));
					employee.setEmail(rs.getString("email"));
					employee.setPassword(rs.getString("password"));
					employee.setEircodeID(rs.getInt("eircodeID"));
				
					return employee;
				}

				return null;
			}

		});
	}

	@Override
	public List<Employee> list() {
		String sql = "SELECT * FROM employee";
		List<Employee> listEmployee = jdbcTemplate.query(sql, new RowMapper<Employee>() {

			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				Employee aemployee = new Employee();
				aemployee.setEmp_id(rs.getInt("emp_id"));
				aemployee.setUsername(rs.getString("username"));
				aemployee.setFirst_name(rs.getString("first_name"));
				aemployee.setSurname(rs.getString("surname"));
				aemployee.setGender(rs.getString("gender"));
				aemployee.setBirth_date(rs.getString("birth_date"));
				aemployee.setStaff_role(rs.getString("staff_role"));
				aemployee.setPhone(rs.getInt("phone"));
				aemployee.setHire_date(rs.getString("hire_date"));
				aemployee.setAddress(rs.getString("address"));
				aemployee.setEmail(rs.getString("email"));
				aemployee.setPassword(rs.getString("password"));
				aemployee.setEircodeID(rs.getInt("eircodeID"));
			
				return aemployee;
			}

		});
		return listEmployee;
	}

}

