import React, { useState } from 'react';
import axios from 'axios';

export const AjoutComposantForm = () => {
    const [composant, setComposant] = useState({
        id: '',
        nom: '',
        description: '',
        quantite: ''
    });

    const [message, setMessage] = useState('');

    const handleChange = (e) => {
        const { name, value } = e.target;
        setComposant(prevComposant => ({
            ...prevComposant,
            [name]: value
        }));
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            const reponse = await axios.post("http://localhost:8080/composants", composant);
            setMessage(`Composant ajouté avec succès: ${reponse.data.nom}`);
            setComposant({
                id: '',
                nom: '',
                description: '',
                quantite: ''
            });
        } catch (error) {
            setMessage('Une erreur est survenue: ' + error.message);
        }
    };

    return (
        <div className="max-w-lg mx-auto mt-10 p-6 bg-white shadow-md rounded-md">
            <form className="space-y-4" onSubmit={handleSubmit}>
                <h1 className="text-xl font-semibold mb-4">Ajout de Composant:</h1>
                <div>
                    <label className="block text-sm font-medium text-gray-700">Nom Composant :</label>
                    <input className="mt-1 p-2 border border-gray-300 rounded-md w-full" value={composant.nom} name={'nom'} onChange={handleChange} />
                </div>
                <div>
                    <label className="block text-sm font-medium text-gray-700">ID Composant :</label>
                    <input className="mt-1 p-2 border border-gray-300 rounded-md w-full" value={composant.id} name={'id'} onChange={handleChange} />
                </div>
                <div>
                    <label className="block text-sm font-medium text-gray-700">Description Composant :</label>
                    <input type="text" className="mt-1 p-2 border border-gray-300 rounded-md w-full" name="description" value={composant.description} onChange={handleChange} />
                </div>
                <div>
                    <label className="block text-sm font-medium text-gray-700">Quantité :</label>
                    <input type="number" className="mt-1 p-2 border border-gray-300 rounded-md w-full" name="quantite" value={composant.quantite} onChange={handleChange} />
                </div>
                <button type={'submit'} className="w-full bg-blue-500 text-white py-2 px-4 rounded-md hover:bg-blue-600">Ajouter</button>
                {message && <p className="mt-4 text-center text-green-500">{message}</p>}
            </form>
        </div>
    );
};
