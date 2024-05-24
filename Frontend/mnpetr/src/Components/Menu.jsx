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

    const showProfile = () => {
        setProfileVisible(true);
    };

    const hideProfile = () => {
        setProfileVisible(false);
    };

    return (
        <div className={'Menu-H'}>
            <div className={'divGauche'}>
                <button onClick={toggleSidebar} className="sidebar-toggle-button mr-2.5">
                    <img src={"./images/sidebarbutton-logo.svg"} alt="Toggle Sidebar" />
                </button>
                <img src={'./images/Sonatrach1.svg'} alt='LOGOSONATRACH' />
                <h1 className="monoton-regular hover:text-white">Sonatrach</h1>
            </div>
            <span className={'divDroite'}>
                <button
                    onMouseEnter={showProfile}
                    onMouseLeave={hideProfile}
                >
                    <span>
                        <img src={"./images/Profile-logo.png"} alt="Profile" />
                    </span>
                </button>

                <span>
                    <img src={"./images/signature.svg"} alt="Logout" className={"energieDuChangement"} />
                </span>
            </span>

            {isProfileVisible && (
                <div className="profile-popup">
                    <h1 className={"orbitron-main"}>Profile</h1>
                    <button onClick={hideProfile}>Close</button>
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
