package com.luv2code.studentapp.department;

import java.util.List;

public interface DepartmentDAO {
   public void save(Department department);
    Department findById(Integer id);
    List<Department> findAll();
}
