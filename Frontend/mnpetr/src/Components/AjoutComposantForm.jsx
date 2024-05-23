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
        <div className="composant-form-container">
            <form className="composant-form" onSubmit={handleSubmit}>
                <h1>Ajout de Composant:</h1>
                <label>Nom Composant :</label>
                <input value={composant.nom} name={'nom'} onChange={handleChange} />
                <label>ID Composant :</label>
                <input value={composant.id} name={'id'} onChange={handleChange} />
                <label>Description Composant :</label>
                <input type="text" name="description" value={composant.description} onChange={handleChange} />
                <label>Quantité :</label>
                <input type="number" name="quantite" value={composant.quantite} onChange={handleChange} />
                <button type={'submit'}>Ajouter</button>
                {message && <p>{message}</p>}
            </form>
        </div>
    );
};
