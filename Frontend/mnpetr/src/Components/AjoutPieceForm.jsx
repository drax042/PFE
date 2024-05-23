
import {setSelectionRange} from "@testing-library/user-event/dist/utils";
import React, {useState} from "react";
import Select from 'react-select';
import makeAnimated from 'react-select/animated';
import axios from 'axios';


export const AjoutPieceForm = () => {

    const [piece,setPiece] = useState({
        id:'',
        nom:'',
        type:'',
        description:'',
        quantite:''
    });

const [message,setMessage] = useState('');

const handleChange = (e) =>{
    const {name, value} = e.target;
    setPiece(prevPiece => ({
        ...prevPiece,
        [name]: value
    }));
}
const handleSubmit = async (e) =>{
    e.preventDefault();
    try{
        const reponse = await axios.post("http://localhost:8080/pieces",piece);
        setMessage(`Piece added successfully: ${reponse.data.nom}`);
        setPiece({
            id:'',
            nom:'',
            type:'',
            descrption:'',
            quantite:''
        });
    } catch (error){
        setMessage('Error occured: ' + error.message);

    }
}


    const [selectedAction, setSelectedAction] = useState('');
    const [selectedEquipment, setSelectedEquipment] = useState(null);

    const handleOptionChange = (event) => {
        setSelectedAction(event.target.value);
    };

    const handleEquipmentChange = (selectedOption) => {
        setSelectedEquipment(selectedOption);
    };

    const equipmentProps = {
        id_equipement: '123456',
        etat_equipement: 'En panne',
    };

    const equipmentOptions = [
        { value: 'pièce 1', label: 'pièce 1' },
        { value: 'pièce 2', label: 'pièce 2' },
        { value: 'pièce 3', label: 'pièce 3' },
        { value: 'pièce 4', label: 'pièce 4' }
    ];

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
        <div className="dt-form-container">
            <form className="dt-form" onSubmit={handleSubmit}>
                <h1>Ajout piece:</h1>
                <label>nom pièce :</label>
                <input value={piece.nom} name={'nom'} onChange={handleChange}/>
                <label>id piece :</label>
                <input value={piece.id} name={'id'} onChange={handleChange}/>
                <label>Type pièce:</label>
                <input type="text" name={"type"} value={piece.type} onChange={handleChange}/>
                <label>Description pièce:</label>
                <input type="text" name="description" value={piece.description} onChange={handleChange}/>
                <label>Quantité:</label>
                <input type={"number"} name={"quantite"} value={piece.quantite} onChange={handleChange}/>
                <button type={'submit'}>Ajouter</button>
            </form>
        </div>
    );
};