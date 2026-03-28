package ma.ensa.jsftp1.service;

import ma.ensa.jsftp1.dao.StudentDao;
import ma.ensa.jsftp1.entity.Student;

import java.util.List;

public class StudentService {
    
    StudentDao studentDao;
    
    public StudentService() {
        studentDao = new StudentDao();
    }

    public List<Student> findAllStudents() {
        return studentDao.findAll();
    }
    public List<Student> findAllFromTo() {
        return studentDao.findAllFromTo();
    }

    public List<Student> findAllPaginated(int page, int pageSize) {
        int firstRecord = ((page - 1) * pageSize);
        int lastRecord = firstRecord + pageSize;
        return studentDao.findAllFromTo(firstRecord, lastRecord);
    }

    public Student findStudentById(int id) {
        return studentDao.findById(id);
    }
    public Student addStudent(Student student) {
        studentDao.create(student);
        return student;
    }
    public Student updateStudent(Student student) {
        studentDao.update(student);
        return student;
    }
    public void deleteStudent(Student student) {
        studentDao.delete(student);
    }
}
