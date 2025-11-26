package com.luv2code.studentapp.security;

import com.luv2code.studentapp.student.Student;
import com.luv2code.studentapp.student.StudentDAO;
import com.luv2code.studentapp.teacher.TeacherDAO;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserServiceimple implements UserDetailsService {

    private StudentDAO studentDAO;
    private TeacherDAO teacherDAO;

    public UserServiceimple(StudentDAO studentDAO, TeacherDAO teacherDAO) {
        this.studentDAO = studentDAO;
        this.teacherDAO = teacherDAO;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        Student student = studentDAO.findByEmail(email).orElse(null)


        return null;
    }
}
