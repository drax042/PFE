package com.example.MNPETR.Model;

import lombok.Builder;

import java.util.Date;

@Builder
public class DemandeDeTravail {
    private int ID_DT;
    private Date Date_Heure;
    private String Description_Panne;

}
