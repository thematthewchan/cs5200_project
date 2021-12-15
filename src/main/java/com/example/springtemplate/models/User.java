package com.example.springtemplate.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String email;
    private String dob;

//    @OneToMany(mappedBy = "user")
//    @JsonIgnore
//    private List<Vehicle> vehicles;
//
//    public List<Vehicle> getVehicles() {
//        return vehicles;
//    }
//
//    public void setSections(List<Vehicle> vehicles) {
//        this.vehicles = vehicles;
//    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getDob() { return dob; }
    public void setDob(String dob) { this.dob = dob; }

    public User(String firstName, String lastName, String username, String password, String email, String dob) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.email = email;
        this.dob = dob;
    }

    public User() {}
}
