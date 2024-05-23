import {Menu} from "../Components/Menu";
import {SideBar} from "../Components/SideBar";
import {DTForm} from "../Components/DTForm";
import {useState} from "react";

export const DT = () => {
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

            <DTForm></DTForm>
        </div>
    )
}