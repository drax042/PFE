import React, { useState } from "react";

export const Menu = ({ toggleSidebar }) => {
    const [isProfileVisible, setProfileVisible] = useState(false);

    const userProfile = {
        prenom: 'Walid',
        nom: 'Talbi',
        email: 'DogShit04@gmail.com',
        matricule: '123456',
        poste: 'Illah SpringBoot'
    };

    const toggleProfileVisibility = () => {
        setProfileVisible(!isProfileVisible);
    };

    return (
        <div className={'Menu-H'}>
            <div className={'divGauche'}>
                <img src={'./images/Sonatrach1.svg'} alt='LOGOSONATRACH' />
                <h1 className="monoton-regular">MNPETR</h1>
            </div>
            <span className={'divDroite'}>
                <button onClick={toggleProfileVisibility}> <span> <img src={"./images/profile-logo.svg"} /> </span></button>
                <button><span className="">  <img src={"./images/logout-logo.svg"}/>  </span></button>
            </span>

            {isProfileVisible && (
                <div className="profile-popup">
                    <h1 className={"orbitron-main"}>Profile</h1>
                    <button onClick={toggleProfileVisibility}>Close</button>
                    <div className="profile-details">
                        <div className="profile-field">
                            <label className="orbitron-main">Nom:</label>
                            <span>{userProfile.nom}</span>
                        </div>
                        <div className="profile-field">
                            <label className="orbitron-main">Prénom:</label>
                            <span>{userProfile.prenom}</span>
                        </div>
                        <div className="profile-field">
                            <label className="orbitron-main">Email:</label>
                            <span>{userProfile.email}</span>
                        </div>
                        <div className="profile-field">
                            <label className="orbitron-main">Matricule:</label>
                            <span>{userProfile.matricule}</span>
                        </div>
                        <div className="profile-field">
                            <label className="orbitron-main">Poste:</label>
                            <span>{userProfile.poste}</span>
                        </div>
                    </div>
                </div>
            )}
        </div>
    );
};