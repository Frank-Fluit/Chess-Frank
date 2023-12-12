import { useMancalaGame } from "../contexts/MancalaGameContext";
import classNames from "classnames";
import Bowl from "../components/BowlRendering";
import { useState } from 'react' 

export const Play = () => {
    const { gameState, setGameState } = useMancalaGame();
    const [originSquare, setoriginSquare] = useState([null, null]); 
    const [targetSquare, setTargetSquare] = useState([null, null]); 

    async function doMove(originSquare: number[],targetSquare: number[]) {
      try {
        const response = await fetch("api/playgame", {
          method: "POST",
          headers: {
            Accept: "application/json",
            "Content-Type": "application/json",
          },
          body: JSON.stringify({
            originSquare: originSquare, 
            targetSquare: targetSquare, 
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

        async function doPotential(originSquare: number[]) {
          try {
            const response = await fetch("api/potential", {
              method: "POST",
              headers: {
                Accept: "application/json",
                "Content-Type": "application/json",
              },
              body: JSON.stringify({
                originSquare: originSquare, 

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

    


    function handleSquareClick(row, col) {
      const location = [7-row, col];
      const location2 = [row,col]
      if (originSquare[0] == null) {
        // If no origin selected, set the selected piece as the origin
        setoriginSquare(location);

        doPotential(location);
      } else {
        // If origin already selected, set the selected location as the target and make the move
        setTargetSquare(location);
        doMove(originSquare, location);
  
        // Clear both selections after the move
        setoriginSquare([null, null]);
        setTargetSquare([null, null]);
      }
    }

   return   <div className="flex  flex-col w-full h-full bg-yellow-500 ">
    <div className="text-center bg-yellow-500 ">

    
      <div className="text-[60px] font-bold">S  C  H  A  A  K</div>
    </div>

    <div className="text-center bg-yellow-500 ">
      <div className="text-3xl font-bold">Kant van speler zwart: {gameState?.players[1]?.hasTurn ? (
  <span className="text-green-700 font-bold">
    {gameState.players[1].name} aan de beurt
  </span>
) : (
  gameState.players[1].name
)} </div>
    </div>


  {/* Middle Section */}
  <div className="flex">
    {/* Left Side Text */}
    <div className="text-center bg-yellow-100 w-[640px]">
      <div className="text-3xl font-bold">Geslagen stukken door wit</div>
    </div>
    

    {/* Board section */}
  <div className="flex  flex-col items-center w-[776px] h-[776px] border-4 border-black bg-black" >

    <div className="grid grid-cols-8 gap-0" style={{ gridTemplateColumns: 'repeat(8, 1fr)' }}>
      {gameState?.squares[0].map((_, colIndex) => (
        <div key={colIndex} className="w-24 h-24 ">
          {gameState.squares.slice().reverse().map((row, rowIndex) => (
            <div key={rowIndex} className={`w-full h-full   border-[3px] flex items-center justify-center

              ${(rowIndex + colIndex) % 2 === 0 ? 'bg-yellow-100' : 'bg-yellow-800'}
              ${gameState.squares.slice().reverse()[rowIndex][colIndex].reachableSquare ? 'bg-green-400 border-black' : 'border-black'}`} onClick={() => handleSquareClick(rowIndex, colIndex)}>
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
    </div>

    <div className="text-center bg-yellow-100 w-[640px] ">
      <div className="text-3xl font-bold">Geslagen stukken door zwart</div>
    </div>
    

  


    
    {/*End of the board div */}










    </div>
    

    <div className="text-center bg-yellow-500">
    <div className="text-3xl font-bold">Kant van speler wit : {gameState?.players[0]?.hasTurn ? (
  <span className="text-green-700 font-bold">
     {gameState.players[0].name} aan de beurt
  </span>
) : (
  gameState.players[0].name
)} </div>

    </div>
  </div>
};