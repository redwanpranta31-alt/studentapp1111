package com.luv2code.studentapp.subject;

import com.luv2code.studentapp.subject.Subject;
import com.luv2code.studentapp.subject.SubjectDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository

public class Subjectdaoimple implements SubjectDAO {

    private EntityManager entityManager;
@Autowired
    public void setEntityManager(EntityManager theentityManager){
        entityManager=  theentityManager;
    }


    @Override
   @Transactional
    public void save(Subject subject) {
        entityManager.persist(subject);
    }

    @Override
    public Subject findById(Integer sub_code) {



        return entityManager.find(Subject.class, sub_code);
    }

    @Override
    public List<Subject> findAll() {
        TypedQuery<Subject> query = entityManager.createQuery("From Subject", Subject.class);
        return query.getResultList();
    }
}
