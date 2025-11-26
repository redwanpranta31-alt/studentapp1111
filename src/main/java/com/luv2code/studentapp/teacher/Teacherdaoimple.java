package com.luv2code.studentapp.teacher;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class Teacherdaoimple implements TeacherDAO {
    private EntityManager entityManager;
    @Autowired
    public void Teacherdaoimple(EntityManager theEntityManager){
        entityManager= theEntityManager;
    }

    @Override
    @Transactional
    public void save(Teacher theTeacher) {
        entityManager.persist(theTeacher);
    }

    @Override
    public Teacher findById(Integer id) {
        return entityManager.find(Teacher.class, id);
    }

    @Override
    public List<Teacher> findAll() {
        TypedQuery <Teacher> query = entityManager.createQuery("From Teacher", Teacher.class);
        return query.getResultList();
    }
}
