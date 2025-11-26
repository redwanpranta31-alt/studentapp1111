package com.luv2code.studentapp.grade;

import java.util.List;

public interface GradeDAO {
    void save(Grade grade);
        Grade findById(Integer id);
        List<Grade> findAll();
}
