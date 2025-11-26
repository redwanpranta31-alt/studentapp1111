package com.luv2code.studentapp.student;

import com.luv2code.studentapp.department.Department;
import com.luv2code.studentapp.grade.Grade;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="student")
public class Student {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id")
    private int id;


@Column (name = "first_name")
    private String first_name;
    @Column(name="last_name")
    private String last_name;
    @Column(name= "email")
    private String email;
    @Column(name = "password")
    private String password;
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Grade> grades;

    public Student() {

    }



    public Student(String first_name, String last_name, String email, String password) {

        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.password= password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }



    public void setEmail(String email) {
        this.email = email;
    }
    public Department getDepartments() {
        return department;
    }

    public void setDepartments(Department department) {
        this.department = department;
    }

    public List<Grade> getGrades() {
        return grades;
    }

    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }

    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password= password;
    }
    public void addGrade(Grade grade) {
        grades.add(grade);
        grade.setStudent(this);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }


}
