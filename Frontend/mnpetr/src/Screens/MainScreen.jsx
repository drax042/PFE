import {SideBar} from "../Components/SideBar";
import { Menu } from "../Components/Menu";
import {useState} from "react";



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