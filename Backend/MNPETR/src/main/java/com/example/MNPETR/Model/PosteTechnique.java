package com.example.MNPETR.Model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@NoArgsConstructor

public class PosteTechnique {
    public int getID_PT() {
        return ID_PT;
    }

    public void setID_PT(int ID_PT) {
        this.ID_PT = ID_PT;
    }

    int ID_PT ;

    public PosteTechnique(int ID_PT) {
        this.ID_PT = ID_PT;
    }
}
