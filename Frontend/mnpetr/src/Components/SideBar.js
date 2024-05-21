import React from 'react';
import { NavLink } from 'react-router-dom';
import { SideBarData } from "../SideBarData";

export function SideBar() {
    return (
        <div className="sidebar">
            <ul className="sidebar-list">
                {SideBarData.map((val, key) => (
                    <li key={key} className="list-item">
                        <NavLink to={val.link} activeClassName="active" className="nav-link">
                            <div className="list-element orbitron-main">
                                <img src={val.icone} alt={`${val.titre} icon`} className="sidebar-icon" />
                                <span className="sidebar-title">{val.titre}</span>
                            </div>
                        </NavLink>
                    </li>
                ))}
            </ul>
        </div>
    );

}
