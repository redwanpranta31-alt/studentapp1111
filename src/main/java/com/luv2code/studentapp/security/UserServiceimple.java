package com.luv2code.studentapp.security;

import com.luv2code.studentapp.student.Student;
import com.luv2code.studentapp.student.StudentDAO;
import com.luv2code.studentapp.teacher.TeacherDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceimple implements UserDetailsService {
    private StudentDAO studentDAO;
    private TeacherDAO teacherDAO;

    @Autowired
    public UserServiceimple(StudentDAO studentDAO, TeacherDAO teacherDAO) {
        this.studentDAO = studentDAO;
        this.teacherDAO = teacherDAO;

    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Student student = studentDAO.findByEmail(email);
        if (student != null) {

            return org.springframework.security.core.userdetails.User
                    .withUsername(student.getEmail())
                    .password(student.getPassword())
                    .roles("STUDENT")
                    .build();
        }
        throw new UsernameNotFoundException("Email not found "+email);

    }
}
