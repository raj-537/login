package com.dcbbank.SpringSecEx.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class Users {
  @Id
  private int id;
  private String email;
  private String username;
  private String password;

  public String getEmail() {
    return email;}

public void setEmail(String email) {
    this.email = email;
}

  public int getId() {
    return id;
}
public void setId(int id) {
    this.id = id;
}
public String getUsername() {
    return username;
}
public void setUsername(String username) {
    this.username = username;
}
public String getPassword() {
    return password;
}
public void setPassword(String password) {
    this.password = password;
}
@Override
public String toString() {
    return "Users{" +
            "id=" + id +
            ", username='" + username + '\'' +
            ", password='" + password + '\'' +
            ", email='" + email + '\'' +
            '}';
}

}
