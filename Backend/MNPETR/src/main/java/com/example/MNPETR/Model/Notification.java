package com.example.MNPETR.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "notification")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String contenu;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateEnvoi;

    private boolean lue;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    @PrePersist
    protected void onCreate() {
        this.dateEnvoi = new Date();
    }
}
