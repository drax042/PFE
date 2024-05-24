import React, { useState, useEffect } from 'react';
import axios from 'axios';

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
        <div>
            <h2 className="text-xl font-bold mb-4 flex align-middle justify-center ">Ordres de Travail</h2>
            <div className="overflow-x-auto justify-center align-items flex">
                <table className="table-auto border-collapse w-3/5">
                    <thead>
                    <tr>
                        <th className="border px-4 py-2">ID</th>
                        <th className="border px-4 py-2">Équipement</th>
                        <th className="border px-4 py-2">Pièce ID</th>
                        <th className="border px-4 py-2">Quantité nécessaire</th>
                        <th className="border px-4 py-2">Date</th>
                        {/* Ajoutez plus de champs au besoin */}
                    </tr>
                    </thead>
                    <tbody>
                    {ordresDeTravail.map(ordreDeTravail => (
                        <tr key={ordreDeTravail.id}>
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
            </div>
        </div>
    );
};
