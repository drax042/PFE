import React, { useState } from 'react';
import { AfficheurEquipement } from '../Components/AfficheurEquipement';
import { AjoutEquipementForm } from '../Components/AjoutEquipementForm';
import {SideBar} from "../Components/SideBar";
import {Menu} from "../Components/Menu";

export const Equipements = () => {
    const [afficherAjoutEquipement, setAfficherAjoutEquipement] = useState(false);

    const [isSidebarVisible, setSidebarVisible] = useState(false);

    const toggleSidebar = () => {
        setSidebarVisible(!isSidebarVisible);
    };

    return (
        <div>
            <div className={`main-container ${isSidebarVisible ? 'sidebar-visible' : ''}`}>
                <Menu toggleSidebar={toggleSidebar}/>
                <SideBar isVisible={isSidebarVisible}/>
            </div>
            <div>
                <AfficheurEquipement/> {/* Affiche le composant AfficheurEquipement */}
                <button onClick={() => setAfficherAjoutEquipement(!afficherAjoutEquipement)}>Afficher le formulaire
                    d'ajout d'équipement
                </button>
                {afficherAjoutEquipement && <AjoutEquipementForm/>} {/* Affiche le formulaire d'ajout d'équipement */}
            </div>
        </div>
    );
};
