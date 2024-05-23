import React, { useState } from 'react';
import axios from 'axios';

export const AjoutEquipementForm = () => {
    const [equipement, setEquipement] = useState({
        ID_Equipement: '',
        Nom_Equipement: '',
        Description_Equipement: '',
        statusEquipement: ''
    });

    const [message, setMessage] = useState('');

    const handleChange = (e) => {
        const { name, value } = e.target;
        setEquipement(prevEquipement => ({
            ...prevEquipement,
            [name]: value
        }));
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            const reponse = await axios.post('http://localhost:8080/equipements', equipement);
            setMessage(`Équipement ajouté avec succès: ${reponse.data.Nom_Equipement}`);
            setEquipement({
                ID_Equipement: '',
                Nom_Equipement: '',
                Description_Equipement: '',
                statusEquipement: ''
            });
        } catch (error) {
            setMessage('Une erreur est survenue: ' + error.message);
        }
    };

    return (
        <div className="max-w-md mx-auto">
            <form onSubmit={handleSubmit} className="bg-white shadow-md rounded px-8 pt-6 pb-8 mb-4">
                <h1 className="text-2xl font-bold mb-4">Ajout d'Équipement:</h1>
                <div className="mb-4">
                    <label className="block text-gray-700 text-sm font-bold mb-2">ID Équipement:</label>
                    <input className="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline" value={equipement.ID_Equipement} name="ID_Equipement" onChange={handleChange} />
                </div>
                <div className="mb-4">
                    <label className="block text-gray-700 text-sm font-bold mb-2">Nom Équipement:</label>
                    <input className="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline" value={equipement.Nom_Equipement} name="Nom_Equipement" onChange={handleChange} />
                </div>
                <div className="mb-4">
                    <label className="block text-gray-700 text-sm font-bold mb-2">Description Équipement:</label>
                    <input className="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline" value={equipement.Description_Equipement} name="Description_Equipement" onChange={handleChange} />
                </div>
                <div className="mb-4">
                    <label className="block text-gray-700 text-sm font-bold mb-2">Status Équipement:</label>
                    <input className="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline" value={equipement.statusEquipement} name="statusEquipement" onChange={handleChange} />
                </div>
                <button className="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline" type="submit">Ajouter</button>
                {message && <p className="text-red-500">{message}</p>}
            </form>
        </div>
    );
};
