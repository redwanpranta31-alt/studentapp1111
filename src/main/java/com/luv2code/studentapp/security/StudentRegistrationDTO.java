package com.luv2code.studentapp.security;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class StudentRegistrationDTO {
@NotBlank(message = "First name is required")
    private String first_name;
    @NotBlank(message = "Last name is required")
    private String last_name;
@Email(message = "Invalid email formate")
    private String email;
    @NotNull(message = "Department ID is required")
    private int department_id;
    @NotBlank(message = "Password can not be blank")
    @Size(min = 8, message = "Password must be at list 8 characters")
    private String password;

    public StudentRegistrationDTO(String first_name, String last_name, String email, int department_id,String password){


        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
       this.department_id = department_id;
       this.password = password;

    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;

}
public  String getPassword(){
        return password;

}
public  void setPassword(String password){
        this.password= password;
}



}