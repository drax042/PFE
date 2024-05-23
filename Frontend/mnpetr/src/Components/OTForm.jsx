
    import {setSelectionRange} from "@testing-library/user-event/dist/utils";
    import React, {useState} from "react";
    import Select from 'react-select';
    import makeAnimated from 'react-select/animated';


    export const OTForm = () => {
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
            { value: 'Équipement 1', label: 'Équipement 1' },
            { value: 'Équipement 2', label: 'Équipement 2' },
            { value: 'Équipement 3', label: 'Équipement 3' },
            { value: 'Équipement 4', label: 'Équipement 4' }
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
                <form className="dt-form">
                    <h1>Ordre de travail :</h1>
                    <label>Équipement:</label>
                    <Select
                        value={selectedEquipment}
                        onChange={handleEquipmentChange}
                        options={equipmentOptions}
                        placeholder="Sélectionnez ou recherchez un équipement"
                        isSearchable
                        components={makeAnimated()}
                        styles={customStyles}
                    />
                    <label>Description panne:</label>
                    <input type="text"/>
                    <label>Action corrective:</label>
                    <div className="radio-options">
                        <label>
                            <input
                                type="radio"
                                value="Réparation"
                                checked={selectedAction === 'Réparation'}
                                onChange={handleOptionChange}
                                name="action"
                            />
                            Réparation
                        </label>
                        <label>
                            <input
                                type="radio"
                                value="Remplacement"
                                checked={selectedAction === 'Remplacement'}
                                onChange={handleOptionChange}
                                name="action"
                            />
                            Remplacement
                        </label>
                    </div>
                    <label>Date de signalement</label>
                    <input type="date"/>
                    <label>Statut DT:</label>
                    <span>{equipmentProps.etat_equipement}</span>
                    <button type={'submit'}>Enregistrer</button>
                </form>
            </div>
        );
    };