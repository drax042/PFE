import {SideBar} from "../Components/SideBar";
import { Menu } from "../Components/Menu";
import {Profile} from "./Profile";



export const MainScreen = () =>{
    return(
        <div>
            <Menu></Menu>
            <SideBar></SideBar>
            <div className={"patern"}><img src="/images/patern-black.png" alt="Pattern Image"
                                           className="_1n5oCrZ4RodOub5uA-y5t9 patern"/></div>
        </div>
    )
}