package service;

import java.util.List;

import daoimpl.StudentDAOImpl;
import models.Student;
import dao.StudentDAO;

public class StudentService implements IstudentService {
	
	StudentDAO studentdao=new StudentDAOImpl();

	@Override
	public Student saveStudent(Student s) {
		
		return studentdao.saveStudent(s);
	}

	@Override
	public Student viewStudentById(int id) {
		// TODO Auto-generated method stub
		return studentdao.viewStudentById(id);
	}

	@Override
	public List<Student> viewAllStudents() {
		// TODO Auto-generated method stub
		return studentdao.viewAllStudents();
	}

	@Override
	public Student updateStudent(Student s) {
		
		return studentdao.updateStudent(s);
	}

	@Override
	public boolean deleteStudent(Student s) {
		return studentdao.deleteStudent(s);
	}
	
	

}
