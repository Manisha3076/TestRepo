package daoimpl;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import dao.StudentDAO;
import models.Status;
import models.Student;
import util.HiberUtil;

public class StudentDAOImpl implements StudentDAO {

	private SessionFactory sessionfactory=HiberUtil.getSessionFactory();
	private Session session=sessionfactory.openSession();
	@Override
	public Student saveStudent(Student s) {
		Transaction tx=session.beginTransaction();
		 session.save(s);
		tx.commit();
		return s;
	}

	@Override
	public Student viewStudentById(int id) {
		return session.load(Student.class, id);
	}

	@Override
	public List<Student> viewAllStudents() {
	    Query<Student> q=session.createQuery("From Student");
		return q.list();
	}

	@Override
	public Student updateStudent(Student s) {
		session.update(s);
		return s;
	}

	@Override
	public boolean deleteStudent(Student s) {
		s.setStatus(Status.INACTIVE);//soft delete
		session.update(s);
		return true;
	}

}
