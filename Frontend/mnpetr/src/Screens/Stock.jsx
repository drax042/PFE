import React, { useState } from "react";
import { AjoutPieceForm } from "../Components/AjoutPieceForm";
import { AfficheurPiece } from "../Components/AfficheurPiece";
import { AfficheurComposant } from "../Components/AfficheurComposant";
import { AjoutComposantForm } from "../Components/AjoutComposantForm";

export const Stock = () => {
    const [afficherAjoutPiece, setAfficherAjoutPiece] = useState(false);
    const [afficherComposants, setAfficherComposants] = useState(false);

    return (
        <div>
            <AfficheurPiece />
            <button
                className="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded mb-4"
                onClick={() => setAfficherAjoutPiece(!afficherAjoutPiece)}
            >
                {afficherAjoutPiece ? "Masquer le formulaire d'ajout de pièce" : "Afficher le formulaire d'ajout de pièce"}
            </button>
            {afficherAjoutPiece && <AjoutPieceForm />}

            <button
                className="bg-green-500 hover:bg-green-700 text-white font-bold py-2 px-4 rounded mb-4"
                onClick={() => setAfficherComposants(!afficherComposants)}
            >
                {afficherComposants ? "Masquer les composants" : "Afficher les composants"}
            </button>
            {afficherComposants && <AfficheurComposant />}
        </div>
    );
};
