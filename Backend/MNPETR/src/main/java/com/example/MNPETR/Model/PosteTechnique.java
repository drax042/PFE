package com.example.MNPETR.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

@Table (name = "PosteTechnique")
public class PosteTechnique {

    @Id
    @Column (name = "ID_PosteTechnique")
    private  int ID_PosteTechnique ;
}
