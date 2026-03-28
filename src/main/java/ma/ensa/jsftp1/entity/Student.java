package ma.ensa.jsftp1.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Student {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Column(unique=true)
    private String email;
    private LocalDate birthday;
    private Double bourse;


    public Student() {
    }

    public Student(int id, String name, String email, LocalDate birthday) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.birthday = birthday;
    }
    public Student( String name, String email, LocalDate birthday) {
        this.name = name;
        this.email = email;
        this.birthday = birthday;
    }
    @Override
    public String toString() {
        return "id : " + id + ", name : " + name + ", email : " + email + ", birthday : " + birthday;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Double getBourse() {
        return bourse;
    }

    public void setBourse(Double bourse) {
        this.bourse = bourse;
    }
}
