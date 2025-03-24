package service;

import java.util.List;

import models.Student;

public interface IstudentService {
	Student saveStudent(Student s);
	Student viewStudentById(int id);
	List<Student> viewAllStudents();
	Student updateStudent(Student s);
	boolean deleteStudent(Student s);


}
