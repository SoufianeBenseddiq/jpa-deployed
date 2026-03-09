package ma.ensa.jsftp1.controller;

import ma.ensa.jsftp1.model.Student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StudentBean {
    private static int id = 3;
    private Student addStudent;
    private List<Student> studentList;
    private Student updatedStudent;


    public StudentBean() {
        addStudent = new Student();
        studentList = new ArrayList<>(List.of(
                new Student(1, "Ali Hassan", "ali.hassan@gmail.com", LocalDate.of(2002, 5, 10)),
                new Student(2, "Sara Benali", "sara.benali@gmail.com", LocalDate.of(2001, 11, 3)),
                new Student(3, "Youssef Karim", "youssef.karim@gmail.com", LocalDate.of(2003, 2, 18))
        ));
    }

    public void addStudent() {
        studentList.add(new Student(++id, addStudent.getName(), addStudent.getEmail(), addStudent.getBirthday()));
        emptyForm();
    }

    public void update(){
        System.out.println( updatedStudent);
        for(Student s: studentList){
            if(s.getId()==updatedStudent.getId()){
                s.setName(updatedStudent.getName());
                s.setEmail(updatedStudent.getEmail());
                s.setBirthday(updatedStudent.getBirthday());
                System.out.println("s = " + s);
            }
        }
        emptyUpdateForm();
        updatedStudent=null;
//        studentList = studentList.stream().map(student->{
//            if(student.getId()==id){
//                student.setName(updatedStudent.getName());
//                student.setEmail(updatedStudent.getEmail());
//                student.setBirthday(updatedStudent.getBirthday());
//                return student;
//            }
//            return student;
//        }).collect(Collectors.toList());
    }

    public void delete(int id) {
        studentList.removeIf(student -> student.getId() == id);
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

    public static int getId() {
        return id;
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
}
