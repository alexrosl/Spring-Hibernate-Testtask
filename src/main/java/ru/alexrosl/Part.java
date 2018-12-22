package com.sample;


public class Part {

  private long id;
  private String name;
  private long quantity;
  private String required;
  private java.sql.Timestamp created;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public long getQuantity() {
    return quantity;
  }

  public void setQuantity(long quantity) {
    this.quantity = quantity;
  }


  public String getRequired() {
    return required;
  }

  public void setRequired(String required) {
    this.required = required;
  }


  public java.sql.Timestamp getCreated() {
    return created;
  }

  public void setCreated(java.sql.Timestamp created) {
    this.created = created;
  }

}
