package com.example.springtemplate.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;

@Entity
@Table(name="engines")
public class Engine {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String layout;
  private Integer cylinder;
  private Float displacement;
  private Integer horsepower;
  private Integer torque;
  private Integer redline;
//  private Integer engineId;

//  @ManyToOne
//  @JsonIgnore
//  private User user;

  public Integer getId() { return id; }
  public void setId(Integer id) { this.id = id; }
  public String getLayout() { return layout; }
  public void setLayout(String layout) { this.layout = layout; }
  public Integer getCylinder() { return cylinder; }
  public void setCylinder(Integer cylinder) { this.cylinder = cylinder; }
  public Float getDisplacement() { return displacement; }
  public void setDisplacement(Float displacement) { this.displacement = displacement; }
  public Integer getHorsepower() { return horsepower; }
  public void setHorsepower(Integer horsepower) { this.horsepower = horsepower; }
  public Integer getTorque() { return torque; }
  public void setTorque(Integer torque) { this.torque = torque; }
  public Integer getRedline() { return redline; }
  public void setRedline(Integer redline) { this.redline = redline; }

  public Engine(String layout, Integer cylinder, Float displacement, Integer horsepower, Integer torque, Integer redline) {
    this.layout = layout;
    this.cylinder = cylinder;
    this.displacement = displacement;
    this.horsepower = horsepower;
    this.torque = torque;
    this.redline = redline;
  }

  public Engine() {}
}
