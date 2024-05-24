import React, { useState, useEffect } from 'react';
import axios from 'axios';

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
        <div>
            <h2 className="text-xl font-bold mb-4 flex align-middle justify-center ">Demandes de Travail</h2>
            <div className="overflow-x-auto flex align-middle justify-center">
                <table className="table-auto border-collapse w-3/5">
                    <thead>
                    <tr>
                        <th className="border px-4 py-2">ID</th>
                        <th className="border px-4 py-2">Équipement</th>
                        <th className="border px-4 py-2">Durée</th>
                        <th className="border px-4 py-2">Date de Signalement</th> {/* Ajout du champ */}
                        {/* Ajoutez plus de champs au besoin */}
                    </tr>
                    </thead>
                    <tbody>
                    {dt.map(dt => (
                        <tr key={dt.id}>
                            <td className="border px-4 py-2">{dt.id}</td>
                            <td className="border px-4 py-2">{dt.equipement}</td>
                            <td className="border px-4 py-2">{dt.duree}</td>
                            <td className="border px-4 py-2">{dt.dateSignalement}</td>
                            {/* Ajoutez plus de champs au besoin */}
                        </tr>
                    ))}
                    </tbody>
                </table>
            </div>
        </div>
    );
};
