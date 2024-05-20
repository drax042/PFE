package com.example.MNPETR.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name="roles")
public class Roles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name ="intitule")
    private String intitule;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;
}