package com.luv2code.studentapp.student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class Studentdaoimple implements StudentDAO {


    private EntityManager entityManager;

    @Autowired
    public void  StudentdaoImple(EntityManager TheEntityManager){

        entityManager= TheEntityManager;
    }


    @Override
    @Transactional
    public void save(Student thestudent) {
        entityManager.persist(thestudent);

    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class,id);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> thequary = entityManager.createQuery("From Student", Student.class);
        return thequary.getResultList();
    }

    @Override
    public Student findByEmail(String email) {
        TypedQuery<Student> quary = entityManager.createQuery("From Student s WHERE s.email = :email",Student.class);
        quary.setParameter("email",email);
        List<Student> result = quary.getResultList();
        return result.isEmpty() ? null : result.get(0);
    }


}

