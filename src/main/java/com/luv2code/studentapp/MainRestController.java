package com.luv2code.studentapp;

import com.luv2code.studentapp.department.Department;
import com.luv2code.studentapp.department.DepartmentDAO;
import com.luv2code.studentapp.grade.Grade;
import com.luv2code.studentapp.grade.GradeDAO;
import com.luv2code.studentapp.security.StudentRegistrationDTO;
import com.luv2code.studentapp.security.StudentService;
import com.luv2code.studentapp.student.Student;
import com.luv2code.studentapp.student.StudentDAO;
import com.luv2code.studentapp.subject.Subject;
import com.luv2code.studentapp.subject.SubjectDAO;
import com.luv2code.studentapp.teacher.Teacher;
import com.luv2code.studentapp.teacher.TeacherDAO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class MainRestController {


    private StudentDAO studentDAO;
    private TeacherDAO teacherDAO;
    private SubjectDAO subjectDAO;
    private DepartmentDAO departmentDAO;
    private GradeDAO gradeDAO;
    private StudentService studentService;


@Autowired
    public MainRestController(StudentDAO studentDAO, TeacherDAO teacherDAO, SubjectDAO subjectDAO, DepartmentDAO departmentDAO, GradeDAO gradeDAO, StudentService studentService) {
        this.studentDAO = studentDAO;
        this.teacherDAO = teacherDAO;
        this.subjectDAO = subjectDAO;
        this.departmentDAO = departmentDAO;
        this.gradeDAO = gradeDAO;
        this.studentService = studentService;
    }

    @PostMapping("/register")
    public Student register(@Valid @RequestBody StudentRegistrationDTO studentRegistrationDTO){

        return studentService.registerStudent(studentRegistrationDTO);

    }


    @PostMapping("/student")
        public Student addStudent(@RequestBody Student student){
        studentDAO.save(student);
        return student;
    }

    @GetMapping("/email/{email}")
    public Student getStudentByEmail(@PathVariable String email) {
        return studentDAO.findByEmail(email);
    }

    @GetMapping("/allstudent")
    public List<Student> allStudents(){
   return studentDAO.findAll();

    }

    @GetMapping("/allstudent/{studentid}")
    public Student getStudent(@PathVariable int studentid){

    return studentDAO.findById(studentid);
    }

    //
    @PostMapping("/teacher")
    public Teacher addTeacher(@RequestBody Teacher teacher){
        teacherDAO.save(teacher);
        return teacher;
    }

    @GetMapping("/allteacher")
    public List<Teacher> allTeachers(){
        return teacherDAO.findAll();

    }

    @GetMapping("/allteacher/{teacherid}")
    public Teacher getTeacher(@PathVariable int teacherid){

        return teacherDAO.findById(teacherid);
    }
    //

    @PostMapping("/subject")
    public Subject addSubject(@RequestBody Subject subject){
        subjectDAO.save(subject);
        return subject;
    }

    @GetMapping("/allsubject")
    public List<Subject> allSubjects(){
        return subjectDAO.findAll();

    }

    @GetMapping("/{subjectid}")
    public Subject getSubject(@PathVariable int subjectid){

        return subjectDAO.findById(subjectid);
    }

    //

    @PostMapping("/department")
    public Department addDepartment(@RequestBody Department department){
        departmentDAO.save(department);
        return department;
    }

    @GetMapping("/alldepartment")
    public List<Department> allDepartments(){
        return departmentDAO.findAll();

    }

    @GetMapping("/{departmentid}")
    public Department getDepartment(@PathVariable int departmentid){

        return departmentDAO.findById(departmentid);
    }
//
@PostMapping("/grade")
public Grade addGrade(@RequestBody Grade grade){
    gradeDAO.save(grade);
    return grade;
}

    @GetMapping("/allgrade")
    public List<Grade> allGrades(){
        return gradeDAO.findAll();

    }

    @GetMapping("/{gradeid}")
    public Grade getGrade(@PathVariable int gradeid){

        return gradeDAO.findById(gradeid);
    }
}


