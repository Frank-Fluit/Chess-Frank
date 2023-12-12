// import { useMancalaGame } from "../contexts/MancalaGameContext";
// import { Play } from "./Play";
// import { Start } from "./Start";
//
// export const Mancala = () => {
//     const { gameState } = useMancalaGame();
//     return gameState ? <Play /> : <Start />;
// };

import { useMancalaGame } from "../contexts/MancalaGameContext";
import { Play } from "./Play";
import { Start } from "./Start";
import { EndGame } from "./EndGame.tsx";

export const Mancala = () => {
    const { gameState } = useMancalaGame();

    if (!gameState) {
        // Render the Start component if there's no gameState
        return <Start />;
    } else if (gameState.gameState.gameState === "NO_ONE") {
        // Render the Play component if there is a gameState and its gameState is "NO_ONE"
        return <Play />;
    }

    // If gameState is defined and gameState.gameState.gameState is not "NO_ONE," nothing is rendered.
    return <EndGame />;
};