package com.luv2code.studentapp.department;

import com.luv2code.studentapp.subject.Subject;
import com.luv2code.studentapp.teacher.Teacher;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "department")
public class Department {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "id")
    private int id;
@Column(name = "dept_name")
    private String dept_name;
@OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
private List<Subject> subjects;
@OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
private List<Teacher> teachers;
public Department(){

}


    public Department(String dept_name) {
        this.dept_name = dept_name;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDept_name() {
        return dept_name;
    }

    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }


    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }




    public void addSubject(Subject subject) {
        subjects.add(subject);
        subject.setDepartment(this);
    }
    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
        teacher.setDepartment(this);
    }


    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", dept_name='" + dept_name + '\'' +
                '}';
    }
}
