import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import chessboardImage from './assets/chessImage.jpg';
import chessboard from './assets/chessboard.jpg';

function App() {
  const [count, setCount] = useState(0);
  const [greeting, setGreeting] = useState('');
  const [player1Name, setPlayer1Name] = useState('');
  const [player2Name, setPlayer2Name] = useState('');
  const [selectedLocation, setSelectedLocation] = useState(''); // To choose a location
  const [moveLocation, setMoveLocation] = useState(''); // To choose a move

  const fetchGreeting = () => {

    fetch('/api/startgame')

      .then((response) => {

        if (!response.ok) {

          throw new Error('Network response was not ok');
        }



        return response.json();
      })
      .then((data) => {
        setGreeting(data);
        console.log(data)
      })
      .catch((error) => {
        console.error('Fetch error:', error);
      });
  };



  return (
    <>
      <h1><b>ChessGame Individual Project Sogyo Frank Fluit</b></h1>
      <div className="card">
        <div className="space-x-4">
          <p className="text-center">Please enter your names:</p>
          <input
            type="text"
            placeholder="Player 1 Name"
            value={player1Name}
            onChange={(e) => setPlayer1Name(e.target.value)}
            className="text-center p-2 border border-black rounded-lg"
          />
          <input
            type="text"
            placeholder="Player 2 Name"
            value={player2Name}
            onChange={(e) => setPlayer2Name(e.target.value)}
            className="text-center p-2 border border-black rounded-lg"
          />
        </div>
        <button onClick={fetchGreeting}>Click <b>here</b> to start the game</button>
        {greeting && (
          <div>
            <p>GET request result:</p>
            <div className="grid grid-cols-8 gap-1">
              {greeting.squares.map((row, rowIndex) => (
                row.map((square, colIndex) => (
                  <div key={colIndex} className="black h-15 w-6 flex justify-center items-center">
                    {square.pieceEnum}
                  </div>
                ))
              ))}
            </div>
          </div>
        )}
        <div>
          <p>Choose a location: </p>
          <input
            type="text"
            value={selectedLocation}
            onChange={(e) => setSelectedLocation(e.target.value)}
          />
        </div>
        <div>
          <p>Choose a move location: </p>
          <input
            type="text"
            value={moveLocation}
            onChange={(e) => setMoveLocation(e.target.value)}
          />
        </div>

      </div>
    </>
  );
}

export default App;
