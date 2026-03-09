package ma.ensa.jsftp1.model;

import java.time.LocalDate;

public class Student {
    private int id;
    private String name;
    private String email;
    private LocalDate birthday;


    public Student() {
    }

    public Student(int id, String name, String email, LocalDate birthday) {
        this.id = id;
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
}
