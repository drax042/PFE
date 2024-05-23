import {useState} from "react";
import {OTForm} from "../Components/OTForm";
import { Menu } from "../Components/Menu";
import {SideBar} from "../Components/SideBar";

export const OT = () => {
    const [isSidebarVisible, setSidebarVisible] = useState(false);

    const toggleSidebar = () => {
        setSidebarVisible(!isSidebarVisible);
    };

    return (
        <div>
        <div className={`main-container ${isSidebarVisible ? 'sidebar-visible' : ''}`}>
            <Menu toggleSidebar={toggleSidebar}  />
            <SideBar isVisible={isSidebarVisible}/>
        </div>
            <OTForm></OTForm>
        </div>
    )
}