import React, { useState } from 'react';
import { AfficheurDT } from "../Components/AfficheurDT";
import { AfficheurOT } from "../Components/AfficheurOT";
import { AfficheurEquipement } from "../Components/AfficheurEquipement";
import { Menu } from "../Components/Menu";
import { SideBar } from "../Components/SideBar";

export const Dashboard = () => {
    const [isSidebarVisible, setSidebarVisible] = useState(false);

    const toggleSidebar = () => {
        setSidebarVisible(!isSidebarVisible);
    };

    return (
        <div className={`main-container ${isSidebarVisible ? 'sidebar-visible' : ''}`}>
            <Menu toggleSidebar={toggleSidebar} />
            <SideBar isVisible={isSidebarVisible} />

            <AfficheurDT />
            <AfficheurOT />
            <AfficheurEquipement />
        </div>
    );
};
