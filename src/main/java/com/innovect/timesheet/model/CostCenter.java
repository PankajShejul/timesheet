package com.innovect.timesheet.model;

import javax.persistence.*;

@Entity
public class CostCenter {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer costCenterId;
  private String name;
  private Double cost;
  private Type type;


  public CostCenter() {
  }

  public CostCenter( String name, Double cost, Integer type) {
    this.name = name;
    this.cost = cost;
    this.type = Type.values()[type];

  }

  public Integer getCostCenterId() {
    return costCenterId;
  }

  public void setCostCenterId(Integer costCenterId) {
    this.costCenterId = costCenterId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Double getCost() {
    return cost;
  }

  public void setCost(Double cost) {
    this.cost = cost;
  }

  public Type getType() {
    return type;
  }

  public void setType(Type type) {
    this.type = type;
  }



  @Override
  public String toString() {
    return "CostCenter{" +
        "costCenterId=" + costCenterId +
        ", name='" + name + '\'' +
        ", cost=" + cost +
        ", type=" + type +
        '}';
  }
}
