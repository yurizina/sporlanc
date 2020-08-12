package cct.sporlanc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import cct.sporlanc.model.Student;

public class StudentDAOImpl implements StudentDAO {

	private JdbcTemplate jdbcTemplate;

	public StudentDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void saveOrUpdate(Student student) {
		if (student.getStudentID() > 0) {
			// update
			String sql = "UPDATE student SET first_name = ?, surname = ?, "
					+ "gender = ?, birth_date = ?, userID = ? WHERE studentID = ?";
			jdbcTemplate.update(sql, student.getFirst_name(), student.getSurname(),
					student.getGender(), student.getBirth_date(), student.getUserID(), student.getStudentID());

		} else {
			//insert new user 
			String sql = "INSERT INTO student (first_name, surname, gender, "
					+ " birth_date, userID) VALUES (?,?,?,?,?)";
			jdbcTemplate.update(sql, student.getFirst_name(), student.getSurname(),
					student.getGender(), student.getBirth_date(), student.getUserID());
		}

	}

	@Override
	public void delete(int studentID) {
		String sql = "DELETE FROM student WHERE studentID = ?";
		jdbcTemplate.update(sql, studentID);

	}

	@Override
	public Student getStudent(int studentID) {
		String sql = "SELECT * FROM student WHERE studentID = " + studentID;

		return jdbcTemplate.query(sql, new ResultSetExtractor<Student>() {

			@Override
			public Student extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					
					Student student = new Student();
					
					student.setStudentID(rs.getInt("studentID"));
					student.setFirst_name(rs.getString("first_name"));
					student.setSurname(rs.getString("surname"));
					student.setGender(rs.getString("gender"));
					student.setBirth_date(rs.getString("birth_date"));
					student.setUserID(rs.getInt("userID"));
					
					return student;
				}

				return null;
			}

		});
	}

	@Override
	public List<Student> list() {
		String sql = "SELECT * FROM student";
		List<Student> listStudent = jdbcTemplate.query(sql, new RowMapper<Student>() {

			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {

				Student students = new Student();
				
				students.setStudentID(rs.getInt("studentID"));
				students.setFirst_name(rs.getString("first_name"));
				students.setSurname(rs.getString("surname"));
				students.setGender(rs.getString("gender"));
				students.setBirth_date(rs.getString("birth_date"));
				students.setUserID(rs.getInt("userID"));
				
				return students;
				
			}

		});
		return listStudent;
	}
	
	@Override
	public List<Student> listEachParent(int user_id) {
		String sql = "SELECT * FROM student WHERE userID = " + user_id;
		
		List<Student> listStudent = jdbcTemplate.query(sql, new RowMapper<Student>() {

			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {

				Student students = new Student();
				
				students.setStudentID(rs.getInt("studentID"));
				students.setFirst_name(rs.getString("first_name"));
				students.setSurname(rs.getString("surname"));
				students.setGender(rs.getString("gender"));
				students.setBirth_date(rs.getString("birth_date"));
				students.setUserID(rs.getInt("userID"));
				
				return students;
				
			}

		});
		return listStudent;
	}
	
	

}
