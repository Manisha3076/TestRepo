package dao;

import java.util.List;

import models.Student;

public interface StudentDAO {
	
	Student saveStudent(Student s);
	Student viewStudentById(int id);
	List<Student> viewAllStudents();
	Student updateStudent(Student s);
	boolean deleteStudent(Student s);

}
