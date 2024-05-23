import React, { useState, useEffect } from 'react';
import axios from 'axios';

export const AfficheurComposant = () => {
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
        <div>
            <h2 className="text-xl font-bold mb-4">Liste des Composants</h2>
            <div className="overflow-x-auto">
                <table className="table-auto border-collapse w-full">
                    <thead>
                    <tr>
                        <th className="border px-4 py-2">ID</th>
                        <th className="border px-4 py-2">Nom</th>
                        <th className="border px-4 py-2">Description</th>
                        <th className="border px-4 py-2">Quantité</th>
                    </tr>
                    </thead>
                    <tbody>
                    {composants.map(composant => (
                        <tr key={composant.id}>
                            <td className="border px-4 py-2">{composant.id}</td>
                            <td className="border px-4 py-2">{composant.nom}</td>
                            <td className="border px-4 py-2">{composant.description}</td>
                            <td className="border px-4 py-2">{composant.quantite}</td>
                        </tr>
                    ))}
                    </tbody>
                </table>
            </div>
        </div>
    );
};
