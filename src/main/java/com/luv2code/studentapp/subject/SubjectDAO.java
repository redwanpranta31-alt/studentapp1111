package com.luv2code.studentapp.subject;

import java.util.List;

public interface SubjectDAO {

    public void save(Subject subject);
    Subject findById(Integer sub_code);
    List<Subject> findAll();

}
