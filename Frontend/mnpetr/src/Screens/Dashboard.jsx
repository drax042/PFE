import React from 'react';
import {AfficheurDT} from "../Components/AfficheurDT";
import {AfficheurOT} from "../Components/AfficheurOT";
import {AfficheurEquipement} from "../Components/AfficheurEquipement";

export const Dashboard = () => {
    return (
        <div>
            <AfficheurDT></AfficheurDT>
            <AfficheurOT></AfficheurOT>
            <AfficheurEquipement></AfficheurEquipement>
        </div>
    );
};

