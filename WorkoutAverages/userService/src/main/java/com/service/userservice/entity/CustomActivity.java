package com.service.userservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SecondaryTable;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "customactivity")
@SecondaryTable(name = "customactivity_db")
public class CustomActivity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", unique = true, nullable = false)
    private long id;

    @Column(name="activity", unique = true, nullable = false, table = "customactivity_db")
    private String activity;

    // @ManyToOne
    // @JoinColumn(name = "username", referencedColumnName = "username")
    // private User user;

    // public User getUser() {
    //     return user;
    // } 

    // public void setUser(User user) {
    //     this.user = user;
    // }
    
}
