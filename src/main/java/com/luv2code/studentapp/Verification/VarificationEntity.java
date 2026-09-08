package com.luv2code.studentapp.Verification;

import com.luv2code.studentapp.student.Student;
import jakarta.persistence.*;

import java.time.LocalDateTime;
@Entity
@Table(name = "VarificationEntity")
public class VarificationEntity {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "Id")
    private Long id;

@Column(name = "Token")
    private String token;
@OneToOne
@JoinColumn(name = "Student_id", referencedColumnName = "id")
    private Student student;

    private LocalDateTime localDateTime;


}
