package com.example.MNPETR.Model;

import lombok.Builder;

import java.util.Date;

@Builder
public class OrdreDeTravail {
    private int ID_OT;
    private int Tot_Horaire;
    private int Duree;
    private String Description_Panne;
    private String Type_Otz;
    private Date Date;

}
