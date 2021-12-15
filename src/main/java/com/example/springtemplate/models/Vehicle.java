package com.example.springtemplate.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;

@Entity
@Table(name="vehicles")
public class Vehicle {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private Integer year;
  private String make;
  private String model;
  private String bodystyle;
  private String color;
  private Integer userId;
  private Integer engineId;
//  private Integer engineId;

//  @ManyToOne
//  @JsonIgnore
//  private User user;

  public Integer getId() { return id; }
  public void setId(Integer id) { this.id = id; }
  public Integer getYear() { return year; }
  public void setYear(Integer year) { this.year = year; }
  public String getMake() { return make; }
  public void setMake(String make) { this.make = make; }
  public String getModel() { return model; }
  public void setModel(String model) { this.model = model; }
  public String getBodystyle() { return bodystyle; }
  public void setBodystyle(String bodystyle) { this.bodystyle = bodystyle; }
  public String getColor() { return color; }
  public void setColor(String color) { this.color = color; }
  public Integer getUserId() { return userId; }
  public void setUserId(Integer userId) { this.userId = userId; }
  public Integer getEngineId() { return engineId; }
  public void setEngineId(Integer engineId) { this.engineId = engineId; }
//  public Integer getEngineId() { return engineId; }
//  public void setEngineId(Integer engineId) { this.engineId = engineId; }

//  public User getUser() { return user; }
//  public void setUser(User user) { this.user = user; }

  public Vehicle(Integer year, String make, String model, String bodystyle, String color, Integer userId, Integer engineId) {
    this.year = year;
    this.make = make;
    this.model = model;
    this.bodystyle = bodystyle;
    this.color = color;
    this.userId = userId;
    this.engineId = engineId;
  }

  public Vehicle() {}
}
