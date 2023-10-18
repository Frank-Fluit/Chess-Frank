import { useMancalaGame } from "../contexts/MancalaGameContext";
import classNames from "classnames";
import Bowl from "../components/BowlRendering";
import { useState } from 'react' // based on old file

export const Play = () => {
    const { gameState, setGameState } = useMancalaGame();
    const [selectedLocation, setSelectedLocation] = useState(''); // To choose a location (based on old file)
    const [moveLocation, setMoveLocation] = useState(''); // To choose a move (based on old file)

    async function doMove(bowlToPlay: number) {
      try {
        const response = await fetch("mancala/api/play", {
          method: "POST",
          headers: {
            Accept: "application/json",
            "Content-Type": "application/json",
          },
          body: JSON.stringify({
            bowlToPlay: bowlToPlay,
          }),
        });

        if (response.ok) {
          const gameState = await response.json();
          setGameState(gameState);
        } else {
          console.error(`HTTP error! Status: ${response.status}`);
        }
      } catch (error) {
        console.error('Fetch error:', error);
      }
    }

    function handleBowlClick(bowlNumber: number) {
        doMove(bowlNumber);
  }


   return   <div className="w-full max-w-md">

    <div className="text-center mb-4">
      <p className="text-xl font-bold">Player 2: {gameState?.players[1].name}</p>
    </div>

    <div className="grid grid-cols-8 gap-0" style={{ gridTemplateColumns: 'repeat(8, 1fr)' }}>
      {gameState?.squares[0].map((_, colIndex) => (
        <div key={colIndex} className="w-20 h-20">
          {gameState.squares.slice().reverse().map((row, rowIndex) => (
            <div key={rowIndex} className={`w-full h-full border border-gray-300 flex items-center justify-center
              ${(rowIndex + colIndex) % 2 === 0 ? 'bg-white-200' : 'bg-green-200'}`}>
              {row[colIndex].pieceEnum !== 'Empty' ? (


                row[colIndex].pieceEnum === 'Pawn' ? (
                  row[colIndex].colour === 'white' ? (
                    <img src="pawn-w.svg" alt="White Pawn" />
                  ) : (
                    <img src="pawn-b.svg" alt="Black Pawn" />
                  )
                ):

                row[colIndex].pieceEnum === 'Knight' ? (
                  row[colIndex].colour === 'white' ? (
                    <img src="knight-w.svg" alt="White knight" />
                  ) : (
                    <img src="knight-b.svg" alt="Black Knight" />
                  )
                ):

                row[colIndex].pieceEnum === 'King' ? (
                  row[colIndex].colour === 'white' ? (
                    <img src="king-w.svg" alt="White king" />
                  ) : (
                    <img src="king-b.svg" alt="Black King" />
                  )
                ):

                row[colIndex].pieceEnum === 'Rook' ? (
                  row[colIndex].colour === 'white' ? (
                    <img src="rook-w.svg" alt="White rook" />
                  ) : (
                    <img src="rook-b.svg" alt="Black rook" />
                  )
                ):

                row[colIndex].pieceEnum === 'Bisshop' ? (
                  row[colIndex].colour === 'white' ? (
                    <img src="bishop-w.svg" alt="White bisshop" />
                  ) : (
                    <img src="bishop-b.svg" alt="Black bisshop" />
                  )
                ):

                row[colIndex].pieceEnum === 'Queen' ? (
                  row[colIndex].colour === 'white' ? (
                    <img src="queen-w.svg" alt="White queen" />
                  ) : (
                    <img src="queen-b.svg" alt="Black queen" />
                  )
                )

                : (
                  <span className="text-red-500">{row[colIndex].pieceEnum}</span>
                )
              ) : null}
            </div>
          ))}
        </div>
      ))}
    </div>
    <br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br />

    <div className="text-center mt-40">
      <p className="text-xl font-bold">Player 1: {gameState?.players[0].name}</p>
    </div>

    <div>
          <p>Format: Rij[0-7], Kolom[0-7], tellen van beide begint linksonder, voorbeeld: 1,1 is een witte pion en 7,7 een zwarte toren 
            </p><p><strong>Selecteer een stuk om te bewegen</strong> </p>
          <input
            type="text"
            value={selectedLocation}
            onChange={(e) => setSelectedLocation(e.target.value)}
          />
        </div>
        <div>
          <p><strong>Selecteer waar je het stuk heen wilt bewegen:</strong></p>
          <input
            type="text"
            value={moveLocation}
            onChange={(e) => setMoveLocation(e.target.value)}
          />
        </div>


  </div>
};