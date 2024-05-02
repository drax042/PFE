package com.example.MNPETR.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor


@Table(name ="composant")
public class Composant {

        @Id
        @Column(name ="id_composant")
        private int ID_Composant ;

@ManyToOne
@JoinColumn(name = "id_piece")
        private Piece piece ;

}
