package com.example.MNPETR.Model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@ToString


public class OrdreDeTravail {
    private int ID_OT ;
    private int Tot_Horaire ;
    private int Duree ;
    private String Description_Panne;
    private String Type_Otz ;
    private int Date ;

}
