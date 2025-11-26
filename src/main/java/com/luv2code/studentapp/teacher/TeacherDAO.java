package com.luv2code.studentapp.teacher;

import java.util.List;

public interface TeacherDAO {

    public void save(Teacher theTeacher);

    Teacher findById(Integer id);
    List<Teacher> findAll();

}
