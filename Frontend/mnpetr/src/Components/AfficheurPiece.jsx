import React, { useState, useEffect } from 'react';
import axios from 'axios';

export const AfficheurPiece = ({ setAfficherAjoutPiece }) => {
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
        <div className="bg-white shadow-lg rounded-lg p-6 mb-6 w-full md:w-1/2">
            <h2 className="text-xl font-bold mb-4 text-center">Liste des Pièces</h2>
            <div className="overflow-x-auto">
                <table className="table-auto w-full text-left">
                    <thead>
                    <tr className="bg-gray-200">
                        <th className="px-4 py-2">ID</th>
                        <th className="px-4 py-2">Nom</th>
                        <th className="px-4 py-2">Type</th>
                        <th className="px-4 py-2">Description</th>
                        <th className="px-4 py-2">Quantité</th>
                    </tr>
                    </thead>
                    <tbody>
                    {pieces.map((piece) => (
                        <tr key={piece.id} className="odd:bg-white even:bg-gray-100">
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
            <button
                className="mt-4 bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded"
                onClick={() => setAfficherAjoutPiece(true)}
            >
                Ajouter Pièce
            </button>
        </div>
    );
};