import React, { useState, useEffect } from 'react';
import axios from 'axios';

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
        <div>
            <h2 className="text-xl font-bold mb-4 flex align-middle justify-center ">Liste des Équipements</h2>
            <div className="overflow-x-auto flex align-middle justify-center">
                <table className="table-auto border-collapse w-3/5">
                    <thead>
                    <tr>
                        <th className="border px-4 py-2">ID</th>
                        <th className="border px-4 py-2">Nom</th>
                        <th className="border px-4 py-2">Description</th>
                        <th className="border px-4 py-2">Status</th>
                    </tr>
                    </thead>
                    <tbody>
                    {equipements.map(equipement => (
                        <tr key={equipement.ID_Equipement}>
                            <td className="border px-4 py-2">{equipement.ID_Equipement}</td>
                            <td className="border px-4 py-2">{equipement.Nom_Equipement}</td>
                            <td className="border px-4 py-2">{equipement.Description_Equipement}</td>
                            <td className="border px-4 py-2">{equipement.statusEquipement}</td>
                        </tr>
                    ))}
                    </tbody>
                </table>
            </div>
        </div>
    );
};
