import React, { useState } from 'react';
import Select from 'react-select';
import makeAnimated from 'react-select/animated';
import axios from 'axios';

export const DTForm = () => {
    const [dt, setDt] = useState({
        id: '',
        equipement: '',
        duree: '',
        DescriptionPanne: '',
        dateSignalement: '',
    });

    const [message, setMessage] = useState('');
    const [equipmentOptions, setEquipmentOptions] = useState([]);

    const handleChange = (e) => {
        const { name, value } = e.target;
        setDt(prevDt => ({
            ...prevDt,
            [name]: value
        }));
    };

    const handleSelectChange = (selectedOption) => {
        setDt(prevDt => ({
            ...prevDt,
            equipement: selectedOption.value
        }));
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            const response = await axios.post('http://localhost:8080/demandesDeTravail', dt);
            setMessage(`DT ajouté avec succès: ${response.data.nom}`);
        } catch (error) {
            setMessage('Erreur: ' + error.message);
        }
    };

    // Render the component
    return (
        <div className="dt-form-container">
            <form className="dt-form" onSubmit={handleSubmit}>
                <h1>Demande de travail:</h1>
                <div className="form-group">
                    <label>Équipement</label>
                    <Select
                        value={equipmentOptions.find(option => option.value === dt.equipement)}
                        onChange={handleSelectChange}
                        options={equipmentOptions}
                        placeholder="Sélectionnez ou recherchez un équipement"
                        isSearchable
                        components={makeAnimated()}
                        className="select-input"
                    />
                </div>
                <div className="form-group-inline">
                    <div className="form-group">
                        <label>Durée</label>
                        <input type="text" name="duree" value={dt.duree} onChange={handleChange} />
                    </div>
                    <div className="form-group">
                        <label>Date de signalement</label>
                        <input type="date" name="dateSignalement" value={dt.dateSignalement} onChange={handleChange} />
                    </div>
                </div>
                <div className="form-group">
                    <label>Description panne</label>
                    <input type="text" name="DescriptionPanne" value={dt.DescriptionPanne} onChange={handleChange} />
                </div>
                <div className="form-group">
                    <label>Action corrective</label>
                    <div className="radio-options">
                        <label>
                            <input
                                type="radio"
                                value="Réparation"
                                checked={dt.action === 'Réparation'}
                                onChange={handleChange}
                                name="action"
                            />
                            Réparation
                        </label>
                        <label>
                            <input
                                type="radio"
                                value="Remplacement"
                                checked={dt.action === 'Remplacement'}
                                onChange={handleChange}
                                name="action"
                            />
                            Remplacement
                        </label>
                    </div>
                </div>
                <button type="submit">Enregistrer</button>
                {message && <p className="message">{message}</p>}
            </form>
        </div>
    );
};