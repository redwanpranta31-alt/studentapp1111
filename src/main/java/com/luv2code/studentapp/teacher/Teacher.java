package com.luv2code.studentapp.teacher;

import com.luv2code.studentapp.department.Department;
import com.luv2code.studentapp.subject.Subject;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name ="teacher")
public class Teacher {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "id")
    private int id;
@Column(name ="first_name")
    private String first_name;
@Column(name = "last_name")
    private  String last_name;
@Column(name = "email")
    private String email;
@Column(name = "password")
private String password;
@ManyToOne
@JoinColumn(name = "department_id")
private Department department;



    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
private List<Subject> subjects ;
    public Teacher(){

    }

    public Teacher(String first_name, String last_name, String email, String password){

        this.first_name = first_name;
        this.last_name = last_name;
        this.email= email;
        this.password= password;
    }

  public int getId(){
        return id;

    }
    public void setId(int id ){
        this.id = id;
    }
    public String getFirstname(){
        return first_name;
    }

    public void setFirst_name(String first_name){
        this.first_name= first_name;
    }

    public String getLast_name(){
        return last_name;
    }
    public void setLastName(String last_name){
        this.last_name= last_name;
    }
    public String getEmail(){
        return  email;
    }
    public  void setEmail(String email){
        this.email =email;
    }
    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void addSubject(Subject subject) {
        subjects.add(subject);
        subject.setTeacher(this);
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", password='"+password+ '\''+
                '}';
    }
}
