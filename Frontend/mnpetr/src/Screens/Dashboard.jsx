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
        <div className={`main-container ${isSidebarVisible ? 'sidebar-visible' : ''} flex flex-col`}>
            <Menu toggleSidebar={toggleSidebar} />
            <SideBar isVisible={isSidebarVisible} />
            <div className="flex flex-col items-center justify-center p-5">
                <div className="flex justify-center items-center mb-5 space-x-5">
                    <AfficheurDT />
                    <AfficheurEquipement />
                </div>
                <div className="flex justify-center items-center">
                    <AfficheurOT />
                </div>
            </div>
        </div>
    );
};
