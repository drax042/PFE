import React, { useState } from "react";
import { SideBar } from "../Components/SideBar";
import { Menu } from "../Components/Menu";

export const MainScreen = () => {
    const [isSidebarVisible, setSidebarVisible] = useState(false);

    const toggleSidebar = () => {
        setSidebarVisible(!isSidebarVisible);
    };

    return (
        <div className={`main-container ${isSidebarVisible ? 'sidebar-visible' : ''}`}>
            <Menu toggleSidebar={toggleSidebar} />
            <SideBar isVisible={isSidebarVisible} />
        </div>
    );
};
