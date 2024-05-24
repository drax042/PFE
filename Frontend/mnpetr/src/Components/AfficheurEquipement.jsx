import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { NavLink } from 'react-router-dom';

export const AfficheurEquipement = () => {
    const [equipements, setEquipements] = useState([]);

    useEffect(() => {
        const recupererEquipements = async () => {
            try {
                const reponse = await axios.get('http://localhost:8080/equipements');
                setEquipements(reponse.data);
            } catch (erreur) {
                console.error('Erreur lors de la récupération des équipements :', erreur);
            }
        };
        recupererEquipements();
    }, []);

    return (
        <div className="bg-white shadow-lg rounded-lg p-6 mb-6 w-full md:w-3/4 lg:w-2/3 xl:w-1/2 mx-auto">
            <h2 className="text-xl font-bold mb-4 text-center text-gray-800">Liste des Équipements</h2>
            <div className="overflow-x-auto">
                <table className="table-auto w-full text-left border-collapse">
                    <thead>
                    <tr className="bg-gray-200 border-b-2 border-gray-300">
                        <th className="px-4 py-2 text-gray-700">ID</th>
                        <th className="px-4 py-2 text-gray-700">Nom</th>
                        <th className="px-4 py-2 text-gray-700">Description</th>
                        <th className="px-4 py-2 text-gray-700">Status</th>
                    </tr>
                    </thead>
                    <tbody>
                    {equipements.map((equipement) => (
                        <tr key={equipement.ID_Equipement} className="odd:bg-white even:bg-gray-50">
                            <td className="border px-4 py-2">{equipement.ID_Equipement}</td>
                            <td className="border px-4 py-2">{equipement.Nom_Equipement}</td>
                            <td className="border px-4 py-2">{equipement.Description_Equipement}</td>
                            <td className="border px-4 py-2">{equipement.statusEquipement}</td>
                        </tr>
                    ))}
                    </tbody>
                </table>
            </div>
            <div className="flex justify-center mt-6">
                <NavLink
                    to="/equipements"
                    className={({ isActive }) =>
                        isActive
                            ? "bg-blue-600 text-white font-bold py-2 px-4 rounded"
                            : "bg-blue-500 text-white font-bold py-2 px-4 rounded hover:bg-blue-700"
                    }
                >
                     Ajouter equipements
                </NavLink>
            </div>
        </div>
    );
};
