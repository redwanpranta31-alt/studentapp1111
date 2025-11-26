package com.luv2code.studentapp.student;

import java.util.List;

public interface StudentDAO {

    public void save(Student thestudent);

    Student findById(Integer id);


    List<Student> findAll();

   Student findByEmail(String email);
}
