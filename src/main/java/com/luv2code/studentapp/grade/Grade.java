package com.luv2code.studentapp.grade;

import com.luv2code.studentapp.student.Student;
import com.luv2code.studentapp.subject.Subject;
import jakarta.persistence.*;

import java.util.Date;
@Entity
@Table (name = "grade")
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "grade")
    private String grade;
    @Column(name = "grade_date")
    private Date grade_date;
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;



    @ManyToOne
    @JoinColumn(name = "sub_code")
    private Subject subject;

    public Grade(){

    }

    public Grade(int id, String grade, Date grade_date) {
        this.id = id;
        this.grade = grade;
        this.grade_date = grade_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Date getGrade_date() {
        return grade_date;
    }

    public void setGrade_date(Date grade_date) {
        this.grade_date = grade_date;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "id=" + id +
                ", grade='" + grade + '\'' +
                ", grade_date=" + grade_date +
                '}';
    }
}
