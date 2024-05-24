import React, { useState, useEffect } from 'react';
import axios from 'axios';

export const AfficheurPiece = () => {
    const [pieces, setPieces] = useState([]);
    const recupererPieces = async () => {
        try {
            const reponse = await axios.get('http://localhost:8080/pieces');
            setPieces(reponse.data);
        } catch (erreur) {
            console.error('Erreur lors de la récupération des pièces :', erreur);
        }
    };

    useEffect(() => {

        recupererPieces();
    }, []);

    return (
        <div>
            <h2 className="text-xl font-bold mb-4 flex align-middle justify-center ">Liste des Pièces</h2>
            <div className="overflow-x-auto justify-center align-middle flex">
                <table className="table-auto border-collapse w-3/5">
                    <thead>
                    <tr>
                        <th className="border px-4 py-2">ID</th>
                        <th className="border px-4 py-2">Nom</th>
                        <th className="border px-4 py-2">Type</th>
                        <th className="border px-4 py-2">Description</th>
                        <th className="border px-4 py-2">Quantité</th>
                    </tr>
                    </thead>
                    <tbody>
                    {pieces.map(piece => (
                        <tr key={piece.id}>
                            <td className="border px-4 py-2">{piece.id}</td>
                            <td className="border px-4 py-2">{piece.nom}</td>
                            <td className="border px-4 py-2">{piece.type}</td>
                            <td className="border px-4 py-2">{piece.description}</td>
                            <td className="border px-4 py-2">{piece.quantite}</td>
                        </tr>
                    ))}
                    </tbody>
                </table>
            </div>
        </div>
    );
};
