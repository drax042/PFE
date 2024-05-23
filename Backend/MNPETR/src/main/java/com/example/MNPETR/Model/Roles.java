package com.example.MNPETR.Model;

import com.example.MNPETR.Model.Enum.intituleRole;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name="roles")
public class Roles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_role")
    private int id;

    @Column(name ="intitule")
    private intituleRole intitule;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;
}