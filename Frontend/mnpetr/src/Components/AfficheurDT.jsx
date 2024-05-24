import React, { useState, useEffect } from 'react';
import axios from 'axios';
import {NavLink} from "react-router-dom";

export const AfficheurDT = () => {
    const [dt, setDt] = useState([]);

    const recupererDt = async () => {
        try {
            const reponse = await axios.get('http://localhost:8080/demanedeDeTravails');
            setDt(reponse.data);
        } catch (erreur) {
            console.error('Erreur lors de la récupération des Demandes de travail :', erreur);
        }
    };

    useEffect(() => {
        recupererDt();
    }, []);

    return (
        <div className="bg-white shadow-lg rounded-lg p-6 mb-6 w-full md:w-3/4 lg:w-2/3 xl:w-1/2 mx-auto">
            <h2 className="text-2xl font-bold mb-6 text-center text-gray-800">Demandes de Travail</h2>
            <div className="overflow-x-auto">
                <table className="table-auto w-full text-left border-collapse">
                    <thead>
                    <tr className="bg-gray-200 border-b-2 border-gray-300">
                        <th className="px-4 py-2 text-gray-700">ID</th>
                        <th className="px-4 py-2 text-gray-700">Équipement</th>
                        <th className="px-4 py-2 text-gray-700">Durée</th>
                        <th className="px-4 py-2 text-gray-700">Date de Signalement</th>
                    </tr>
                    </thead>
                    <tbody>
                    {dt.map((demandeTravail) => (
                        <tr key={demandeTravail.id} className="odd:bg-white even:bg-gray-50">
                            <td className="border px-4 py-2">{demandeTravail.id}</td>
                            <td className="border px-4 py-2">{demandeTravail.equipement}</td>
                            <td className="border px-4 py-2">{demandeTravail.duree}</td>
                            <td className="border px-4 py-2">{demandeTravail.dateSignalement}</td>
                        </tr>
                    ))}
                    </tbody>
                </table>
            </div>
            <div className="flex justify-center mt-6">
                <NavLink
                    to="/dt"
                    className={({isActive}) =>
                        isActive
                            ? "bg-blue-600 text-white font-bold py-2 px-4 rounded"
                            : "bg-blue-500 text-white font-bold py-2 px-4 rounded hover:bg-blue-700"
                    }
                >
                    Ajouter une DT
                </NavLink>
            </div>
        </div>
    );
};
