// Navigation.js
import React, { useState } from 'react';
import Box from '@mui/material/Box';
import Stack from '@mui/material/Stack';
import Slider from '@mui/material/Slider';
import VolumeDown from '@mui/icons-material/VolumeDown';
import VolumeUp from '@mui/icons-material/VolumeUp';
import { NavLink } from "react-router-dom";

export const Navigation = () => {
    const [value, setValue] = useState(30);
    const [nombre, setNombre] = useState(0);

    const handleChange = (event, newValue) => {
        setValue(newValue);
    };

    const handleReset = () => {
        setNombre(0);
    };

    const handleIncrement = () => {
        setNombre(prevNombre => prevNombre + 1);
    };

    const handleMegaIncrement =() =>{
        setNombre(prevNombre => prevNombre*1000) ;
    }

    return (
        <div>
            <nav>
                <NavLink to="/">Accueil</NavLink>
                <NavLink to="/dashbord">Dashboard</NavLink>
                <NavLink to="/redaction">Redaction</NavLink>
            </nav>

            <Box sx={{ width: 200 }}>
                <Stack spacing={2} direction="row" sx={{ mb: 1 }} alignItems="center">
                    <VolumeDown />
                    <Slider aria-label="Volume" value={value} onChange={handleChange} />
                    <VolumeUp />
                </Stack>
                <Slider disabled defaultValue={30} aria-label="Disabled slider" />
            </Box>

            <h1>Nombre : {nombre}</h1>
            <h1>value : {value}</h1>

            <button type="button" onClick={handleReset}>
                Réinitialiser
            </button>
            <button type="button" onClick={handleIncrement}>
                Incrémenter
            </button>

            <button type={"button"} onClick={handleMegaIncrement} >
                Mega Incrementationnnn de fou furieux
            </button>
        </div>
    );
}
