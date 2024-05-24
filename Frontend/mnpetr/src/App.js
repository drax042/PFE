// App.js
import React, {useState} from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import { Menu } from './Components/Menu';
import { Login } from './Screens/Login';
import { SideBar } from './Components/SideBar';
import { MainScreen } from './Screens/MainScreen';
import {Profile} from "./Screens/Profile";
import {OT} from "./Screens/OT";
import {DT} from "./Screens/DT";
import {Stock} from "./Screens/Stock";
import {Dashboard} from "./Screens/Dashboard";
import {Equipements} from "./Screens/Equipements";

function App() {
    const [isSidebarVisible, setSidebarVisible] = useState(false);

    const toggleSidebar = () => {
        setSidebarVisible(!isSidebarVisible);
    };
    return (
        <Router>
            <div className="app">
                <Routes>
                    <Route path="/" element={<div />} />
                    <Route path="/sidebar" element={<SideBar />} />
                    <Route path="/login" element={<Login  />} />
                    <Route path="/mainscreen" element={<MainScreen/>} />
                    <Route path="/ot" element={<OT/>} />
                    <Route path="/profile" element={<Profile/>} />
                    <Route path="/dt" element={<DT/>} />
                    <Route path="/stock" element={<Stock/>} />
                    <Route path="/dashboard" element={<Dashboard/>} />
                    <Route path="/equipements" element={<Equipements/>} />

                </Routes>
            </div>

        </Router>
    );
}

export default App;
