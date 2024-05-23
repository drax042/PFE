import React, { useState } from 'react';
import { AfficheurEquipement } from '../Components/AfficheurEquipement';
import { AjoutEquipementForm } from '../Components/AjoutEquipementForm';

export const Equipements = () => {
    const [afficherAjoutEquipement, setAfficherAjoutEquipement] = useState(false);

    return (
        <div>
            <AfficheurEquipement /> {/* Affiche le composant AfficheurEquipement */}
            <button onClick={() => setAfficherAjoutEquipement(!afficherAjoutEquipement)}>Afficher le formulaire d'ajout d'équipement</button>
            {afficherAjoutEquipement && <AjoutEquipementForm />} {/* Affiche le formulaire d'ajout d'équipement */}
        </div>
    );
};
