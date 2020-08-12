package cct.sporlanc.dao;

import java.util.List;

import cct.sporlanc.model.Student;

public interface StudentDAO {
	public void saveOrUpdate(Student student);

	public void delete(int studentID);

	public Student getStudent(int studentID);

	public List<Student> list();

	public List<Student> listEachParent(int user_id);
}
