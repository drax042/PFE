import React, { useState, useEffect } from 'react';
import axios from 'axios';

export const AfficheurComposant = ({ setAfficherAjoutComposant }) => {
    const [composants, setComposants] = useState([]);
    const recupererComposants = async () => {
        try {
            const reponse = await axios.get('http://localhost:8080/composants');
            setComposants(reponse.data);
        } catch (erreur) {
            console.error('Erreur lors de la récupération des composants :', erreur);
        }
    };

    useEffect(() => {
        recupererComposants();
    }, []);

    return (
        <div className="bg-white shadow-lg rounded-lg p-6 mb-6 w-full md:w-1/2">
            <h2 className="text-xl font-bold mb-4 text-center">Liste des Composants</h2>
            <div className="overflow-x-auto">
                <table className="table-auto w-full">
                    <thead>
                    <tr className="bg-gray-200">
                        <th className="px-4 py-2">ID</th>
                        <th className="px-4 py-2">Nom</th>
                        <th className="px-4 py-2">Description</th>
                        <th className="px-4 py-2">Quantité</th>
                    </tr>
                    </thead>
                    <tbody>
                    {composants.map(composant => (
                        <tr key={composant.id} className="bg-white border-b">
                            <td className="px-4 py-2">{composant.id}</td>
                            <td className="px-4 py-2">{composant.nom}</td>
                            <td className="px-4 py-2">{composant.description}</td>
                            <td className="px-4 py-2">{composant.quantite}</td>
                        </tr>
                    ))}
                    </tbody>
                </table>
            </div>
            <button
                className="mt-4 bg-green-500 hover:bg-green-700 text-white font-bold py-2 px-4 rounded"
                onClick={() => setAfficherAjoutComposant(true)}
            >
                Ajouter Composant
            </button>
        </div>
    );
};
