package com.luv2code.studentapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class StudentappApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentappApplication.class, args);
	}

   /* @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {
            //createStudents(studentDAO);
            //readStudent(studentDAO);
            readallStudent(studentDAO);
        };
    }
    private void readStudent(StudentDAO studentDAO) {
        Student s4 = new Student("Akbar", "Jitu", "jitu@gmail.com");
        studentDAO.save(s4);
        int theid = s4.getId();
        System.out.println(theid);
        Student myStudent = studentDAO.findById(theid);
        System.out.println(myStudent);
    }

    private void createStudents(StudentDAO studentDAO) {
0.
        Student s1 = new Student("Redwan", "Pranta", "redwan@gmail.com");
        Student s2 = new Student("Abdullah", "Mahfuj", "mahfuj@gmail.com");
        Student s3 = new Student("Mohammad", "Karim", "karim@gmail.com");


        studentDAO.save(s1);
        studentDAO.save(s2);
        studentDAO.save(s3);

        System.out.println("Saved student IDs: " + s1.getId() + ", " + s2.getId() + ", " + s3.getId());
    }
    public void readallStudent(StudentDAO studentDAO){

        List<Student> theStudents = studentDAO.findAll();
        for(int i = 0; i<theStudents.size(); i++ ){

            System.out.println(theStudents.get(i));
        }

    }*/


}


