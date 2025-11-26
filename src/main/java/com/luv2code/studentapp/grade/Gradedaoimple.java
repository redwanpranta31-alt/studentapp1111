package com.luv2code.studentapp.grade;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class Gradedaoimple implements GradeDAO {

    private EntityManager entityManager;
    @Autowired
    public void setGradedaoimple (EntityManager theEntitymanager){
        entityManager= theEntitymanager;
    }

    @Override
    @Transactional
    public void save(Grade grade) {
        entityManager.persist(grade);
    }

    @Override
    public Grade findById(Integer id) {
        return entityManager.find(Grade.class, id);
    }

    @Override
    public List<Grade> findAll() {
        TypedQuery <Grade> query = entityManager.createQuery("From Grade", Grade.class);
        return query.getResultList();
    }
}
