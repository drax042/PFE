import React, { useState } from "react";
import { AfficheurPiece } from "../Components/AfficheurPiece";
import { AfficheurComposant } from "../Components/AfficheurComposant";
import { AjoutPieceForm } from "../Components/AjoutPieceForm";
import { AjoutComposantForm } from "../Components/AjoutComposantForm";
import { Menu } from "../Components/Menu";
import { SideBar } from "../Components/SideBar";

export const Stock = () => {
    const [afficherAjoutPiece, setAfficherAjoutPiece] = useState(false);
    const [afficherAjoutComposant, setAfficherAjoutComposant] = useState(false);
    const [isSidebarVisible, setSidebarVisible] = useState(false);

    const toggleSidebar = () => {
        setSidebarVisible(!isSidebarVisible);
    };

    return (
        <div>
            <Menu toggleSidebar={toggleSidebar} />
            <div className="relative flex">
                <SideBar isVisible={isSidebarVisible} />
                <div className={`flex flex-col flex-grow ${isSidebarVisible ? 'ml-64' : ''} transition-all duration-300 ease-in-out`}>
                    <div className="flex justify-center mt-6">
                        <div className="flex flex-wrap justify-around w-11/12">
                            <AfficheurPiece setAfficherAjoutPiece={setAfficherAjoutPiece} />
                            <AfficheurComposant setAfficherAjoutComposant={setAfficherAjoutComposant} />
                        </div>
                    </div>
                    {afficherAjoutPiece && (
                        <div className="fixed inset-0 bg-black bg-opacity-50 flex justify-center items-center">
                            <div className="bg-white p-6 rounded-lg shadow-lg w-1/2">
                                <AjoutPieceForm />
                                <button
                                    className="mt-4 bg-red-500 hover:bg-red-700 text-white font-bold py-2 px-4 rounded"
                                    onClick={() => setAfficherAjoutPiece(false)}
                                >
                                    Fermer
                                </button>
                            </div>
                        </div>
                    )}
                    {afficherAjoutComposant && (
                        <div className="fixed inset-0 bg-black bg-opacity-50 flex justify-center items-center">
                            <div className="bg-white p-6 rounded-lg shadow-lg w-1/2">
                                <AjoutComposantForm />
                                <button
                                    className="mt-4 bg-red-500 hover:bg-red-700 text-white font-bold py-2 px-4 rounded"
                                    onClick={() => setAfficherAjoutComposant(false)}
                                >
                                    Fermer
                                </button>
                            </div>
                        </div>
                    )}
                </div>
            </div>
        </div>
    );
};
