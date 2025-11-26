package com.luv2code.studentapp.security;

import com.luv2code.studentapp.exceptionhandler.DuplicateEmailException;
import com.luv2code.studentapp.exceptionhandler.InvalidDepartmentException;
import com.luv2code.studentapp.department.Department;
import com.luv2code.studentapp.department.DepartmentDAO;
import com.luv2code.studentapp.student.Student;
import com.luv2code.studentapp.student.StudentDAO;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImple implements StudentService {

    private StudentDAO studentDAO;
    private DepartmentDAO departmentDAO;

    public StudentServiceImple(StudentDAO studentDAO, DepartmentDAO departmentDAO) {

        this.studentDAO = studentDAO;
        this.departmentDAO = departmentDAO;
    }


    @Override
    public Student registerStudent(StudentRegistrationDTO studentRegistrationDTO) {
        Department department = departmentDAO.findById(studentRegistrationDTO.getDepartment_id());
        if (department == null) {
            throw new InvalidDepartmentException("Invalid Department id" + studentRegistrationDTO.getDepartment_id());

        }

        Student existing = studentDAO.findByEmail(studentRegistrationDTO.getEmail());
        if (existing != null) {
            throw new DuplicateEmailException("Email already registerd" + studentRegistrationDTO.getEmail());
        }
        Student student = new Student();
        student.setFirst_name(studentRegistrationDTO.getFirst_name());
        student.setLast_name(studentRegistrationDTO.getLast_name());
        student.setEmail(studentRegistrationDTO.getEmail());
        student.setDepartments(department);

        studentDAO.save(student);
        return student;


    }
}
