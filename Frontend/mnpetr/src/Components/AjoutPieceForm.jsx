import {setSelectionRange} from "@testing-library/user-event/dist/utils";
import React, {useState} from "react";
import Select from 'react-select';
import makeAnimated from 'react-select/animated';
import axios from 'axios';

export const AjoutPieceForm = () => {

    const [piece, setPiece] = useState({
        id: '',
        nom: '',
        type: '',
        description: '',
        quantite: ''
    });

    const [message, setMessage] = useState('');

    const handleChange = (e) =>{
        const {name, value} = e.target;
        setPiece(prevPiece => ({
            ...prevPiece,
            [name]: value
        }));
    };

    const handleSubmit = async (e) =>{
        e.preventDefault();
        try{
            const reponse = await axios.post("http://localhost:8080/pieces", piece);
            setMessage(`Piece added successfully: ${reponse.data.nom}`);
            setPiece({
                id: '',
                nom: '',
                type: '',
                descrption: '',
                quantite: ''
            });
        } catch (error){
            setMessage('Error occured: ' + error.message);
        }
    };

    const customStyles = {
        control: (provided) => ({
            ...provided,
            width: '100%',
            border: '1px solid #ccc',
            borderRadius: '5px',
            padding: '10px',
            marginBottom: '20px'
        }),
        singleValue: (provided) => ({
            ...provided,
            width: 'calc(100% - 20px)' // Adjust to fit within padding
        }),
        input: (provided) => ({
            ...provided,
            width: 'calc(100% - 20px)' // Adjust to fit within padding
        })
    };

    return (
        <div className="max-w-lg mx-auto mt-10 p-6 bg-white shadow-md rounded-md">
            <form className="space-y-4" onSubmit={handleSubmit}>
                <h1 className="text-xl font-semibold mb-4">Ajout piece:</h1>
                <div>
                    <label className="block text-sm font-medium text-gray-700">nom pièce :</label>
                    <input className="mt-1 p-2 border border-gray-300 rounded-md w-full" value={piece.nom} name={'nom'} onChange={handleChange}/>
                </div>
                <div>
                    <label className="block text-sm font-medium text-gray-700">id piece :</label>
                    <input className="mt-1 p-2 border border-gray-300 rounded-md w-full" value={piece.id} name={'id'} onChange={handleChange}/>
                </div>
                <div>
                    <label className="block text-sm font-medium text-gray-700">Type pièce:</label>
                    <input type="text" className="mt-1 p-2 border border-gray-300 rounded-md w-full" name={"type"} value={piece.type} onChange={handleChange}/>
                </div>
                <div>
                    <label className="block text-sm font-medium text-gray-700">Description pièce:</label>
                    <input type="text" className="mt-1 p-2 border border-gray-300 rounded-md w-full" name="description" value={piece.description} onChange={handleChange}/>
                </div>
                <div>
                    <label className="block text-sm font-medium text-gray-700">Quantité:</label>
                    <input type="number" className="mt-1 p-2 border border-gray-300 rounded-md w-full" name={"quantite"} value={piece.quantite} onChange={handleChange}/>
                </div>
                <button type={'submit'} className="w-full bg-blue-500 text-white py-2 px-4 rounded-md hover:bg-blue-600">Ajouter</button>
                {message && <p className="mt-4 text-center text-green-500">{message}</p>}
            </form>
        </div>
    );
};
