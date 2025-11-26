package com.luv2code.studentapp.department;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class Departmentdaoimple implements DepartmentDAO {
    private EntityManager entityManager;

    @Autowired
    public void Departmentdaoimple(EntityManager theentityManager){

        entityManager= theentityManager;
    }

    @Override
    @Transactional
    public void save(Department department) {
        entityManager.persist(department);
    }

    @Override
    public Department findById(Integer id) {
        return entityManager.find(Department.class, id);
    }

    @Override
    public List<Department> findAll() {
        TypedQuery <Department> query = entityManager.createQuery("From Department", Department.class);
        return query.getResultList();
    }
}
