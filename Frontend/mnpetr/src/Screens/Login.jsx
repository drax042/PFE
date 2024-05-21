import React from 'react';
import { Menu } from '../Components/Menu';

export const Login = () => {
    return (
        <div className="app">
            <Menu></Menu>
            <div className='Container_Login'>
                <div className='DivGauche_Login'>
                    <img className='image_tuyau' alt='Maintenance' src='../images/martin-adams-a_PDPUPuNZ8-unsplash.jpg' />
                </div>
                <div className='DivDroite_Login'>
                    <form className='Formulaire_Login orbitron-main'>
                        <div>
                            <div className='image_Sonatrach_Login'>
                                <img src='./images/download.png' alt='Sonatrach Logo' />
                            </div>
                            <h1>Connexion :</h1>

                            <label htmlFor='matricule'>Matricule :</label>
                            <input type='text' id='matricule' name='matricule' placeholder='Matricule' />

                            <label htmlFor='password'>Mot de passe :</label>
                            <input type='password' id='password' name='password' placeholder='Mot de Passe' />
                        </div>
                        <div>
                            <button className='orbitron-main' type='submit'>S'authentifier</button>
                            <p>Un problème ? <span className='hoverable' style={{ textDecoration: 'underline' }}>cliquez ici</span></p>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    );
}