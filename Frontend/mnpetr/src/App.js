// App.js
import React from "react";
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import { Navigation } from "./Components/Navigation";
import Dashboard from "./Screens/Dashborodos/Dashbord";
import { Redaction } from "./Screens/Redaction";
import { Home } from "./Screens/Home";

function App() {
    return (
        <Router>
            <div>
                <Routes>
                    <Route path="/" element={<Home />} />
                    <Route path="/dashbord" element={<Dashboard />} />
                    <Route path="/redaction" element={<Redaction />} />
                </Routes>
            </div>
        </Router>
    );
}

export default App;
