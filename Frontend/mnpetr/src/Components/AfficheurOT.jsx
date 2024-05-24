import React, { useState, useEffect } from 'react';
import axios from 'axios';
import {NavLink} from "react-router-dom";

export const AfficheurOT = () => {
    const [ordresDeTravail, setOrdresDeTravail] = useState([]);

    const recupererOrdresDeTravail = async () => {
        try {
            const reponse = await axios.get('http://localhost:8080/ordreDeTravails');
            setOrdresDeTravail(reponse.data);
        } catch (erreur) {
            console.error('Erreur lors de la récupération des Ordres de Travail :', erreur);
        }
    };

    useEffect(() => {
        recupererOrdresDeTravail();
    }, []);

    return (
        <div className="bg-white shadow-lg rounded-lg p-6 mb-6 w-full overflow-x-auto">
            <h2 className="text-2xl font-bold mb-6 text-center text-gray-800">Ordres de Travail</h2>
            <table className="table-auto w-full text-left border-collapse">
                <thead>
                <tr className="bg-gray-200">
                    <th className="px-4 py-2 text-gray-700">ID</th>
                    <th className="px-4 py-2 text-gray-700">Équipement</th>
                    <th className="px-4 py-2 text-gray-700">Pièce ID</th>
                    <th className="px-4 py-2 text-gray-700">Quantité nécessaire</th>
                    <th className="px-4 py-2 text-gray-700">Date</th>
                    {/* Ajoutez plus de champs au besoin */}
                </tr>
                </thead>
                <tbody>
                {ordresDeTravail.map((ordreDeTravail) => (
                    <tr key={ordreDeTravail.id} className="odd:bg-white even:bg-gray-50">
                        <td className="border px-4 py-2">{ordreDeTravail.id}</td>
                        <td className="border px-4 py-2">{ordreDeTravail.equipement}</td>
                        <td className="border px-4 py-2">{ordreDeTravail.pieceID}</td>
                        <td className="border px-4 py-2">{ordreDeTravail.quantityNeeded}</td>
                        <td className="border px-4 py-2">{ordreDeTravail.date}</td>
                        {/* Ajoutez plus de champs au besoin */}
                    </tr>
                ))}
                </tbody>
            </table>
            <div className="flex justify-center mt-6">
                <NavLink
                    to="/ot"
                    className={({isActive}) =>
                        isActive
                            ? "bg-blue-600 text-white font-bold py-2 px-4 rounded"
                            : "bg-blue-500 text-white font-bold py-2 px-4 rounded hover:bg-blue-700"
                    }
                >
                    Ajouter un OT
                </NavLink>
            </div>
        </div>
    );
};
