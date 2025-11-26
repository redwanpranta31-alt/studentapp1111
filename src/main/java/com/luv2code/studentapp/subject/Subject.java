package com.luv2code.studentapp.subject;

import com.luv2code.studentapp.department.Department;
import com.luv2code.studentapp.grade.Grade;
import com.luv2code.studentapp.teacher.Teacher;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "subject")
public class Subject {

    @Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column (name = "sub_code")
    private int sub_code;

@Column (name ="sub_name")
    private String sub_name;
@Column (name ="sub_type")
    private String sub_type;

@ManyToOne
@JoinColumn (name = "teacher_id")
private Teacher teacher;
@ManyToOne
@JoinColumn (name= "department_id")
private Department department;
@OneToMany(mappedBy = "subject", cascade = CascadeType.ALL)
private List<Grade> grades;
public Subject(){

}

    public Subject ( String sub_name, String sub_type){

        this.sub_name = sub_name;
        this.sub_type= sub_type;


    }

     public int getSubCode(){
        return sub_code;
     }
     public void setSubCode(int sub_code){
        this.sub_code = sub_code;


     }
     public String getSub_name(){
        return sub_name;
     }
     public void setSub_name(String sub_name){
        this.sub_name= sub_name;
     }
    public String getSub_type(){
        return sub_type;
    }
    public void setSub_type(String sub_type){
        this.sub_type = sub_type;
    }
    public Teacher getTeacher(){
        return teacher;
    }
    public void setTeacher(Teacher teacher){
        this.teacher= teacher;
    }
    public Department getDepartment(){
        return department;
    }
    public void setDepartment(Department department){
        this.department= department;
    }
    public List<Grade> getGrades(){
        return grades;
    }
    public void setGrades(List<Grade> grades){
        this.grades= grades;
    }
    public void addGrade(Grade grade) {
        grades.add(grade);
        grade.setSubject(this);
    }

    @Override
    public String toString() {
        return "Subject{" +
                "sub_code=" + sub_code +
                ", sub_name='" + sub_name + '\'' +
                ", sub_type='" + sub_type + '\'' +
                '}';
    }
}
