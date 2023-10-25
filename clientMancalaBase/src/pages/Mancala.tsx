
import { useMancalaGame } from "../contexts/MancalaGameContext";
import { Play } from "./Play";
import { Start } from "./Start";
import { EndGame } from "./EndGame";
import { MatchHistory} from "./MatchHistory";

export const Mancala = () => {
    const { gameState } = useMancalaGame();

    if (!gameState) {
        return <Start />;
    } else if (gameState.gameState.gameState !== "NO_ONE") {
        return <MatchHistory/>;
    } else {
        return <Play />;
    }
};