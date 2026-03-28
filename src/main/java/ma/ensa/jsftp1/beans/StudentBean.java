package ma.ensa.jsftp1.beans;

import jakarta.inject.Named;
import ma.ensa.jsftp1.entity.Student;
import ma.ensa.jsftp1.service.StudentService;

import java.util.ArrayList;
import java.util.List;

@Named
public class StudentBean {
    private Student addStudent;
    private List<Student> studentList;
    private Student updatedStudent;
    StudentService studentService ;
    int totalPages=10;
    List<Integer> pages = new ArrayList<>();
    int currentPage=1;
    int pageSize=2;


    public StudentBean() {
        addStudent = new Student();
        studentService = new StudentService();
        initStudentList();
    }


    public void initStudentList(){
        studentList = studentService.findAllStudents();
    }

    public void findPaginated(int pageNo){
        studentList = studentService.findAllPaginated(pageNo,pageSize);
    }

    public void addStudent() {
        studentService.addStudent(addStudent);
        initStudentList();
        emptyForm();
    }

    public void update(){
//        System.out.println( updatedStudent);
        studentService.updateStudent(updatedStudent);
        initStudentList();
        emptyUpdateForm();
        updatedStudent=null;
    }

    public void delete(Student student) {
        studentService.deleteStudent(student);
        initStudentList();
    }

    private void emptyForm(){
        addStudent.setName(null);
        addStudent.setEmail(null);
        addStudent.setBirthday(null);
    }

    private void emptyUpdateForm(){
        updatedStudent.setName(null);
        updatedStudent.setEmail(null);
        updatedStudent.setBirthday(null);
    }

    public void clearTable(){
        studentList.clear();
    }

    public Student getAddStudent() {
        return addStudent;
    }

    public void setAddStudent(Student addStudent) {
        this.addStudent = addStudent;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public Student getUpdatedStudent() {
        return updatedStudent;
    }

    public void setUpdatedStudent(Student updatedStudent) {
        this.updatedStudent = new Student(
                updatedStudent.getId(),
                updatedStudent.getName(),
                updatedStudent.getEmail(),
                updatedStudent.getBirthday()
        );
    }

    public List<Integer> getPages() {
        for (int i = 1; i <= totalPages; i++) {
            pages.add(i);
        }
        return pages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
