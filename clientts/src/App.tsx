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

  const fetchGreeting = () => {

    fetch('/api/startgame')

      .then((response) => {

        if (!response.ok) {

          throw new Error('Network response was not ok');
        }



        return response.text();
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
          <p className="text-center ">Please enter your names:</p> {/* Prompt text */}
          <input
            type="text"
            placeholder="Player 1 Name"
            value={player1Name}
            onChange={(e) => setPlayer1Name(e.target.value)}
            className="text-center p-2 border border-black rounded-lg" // Add borders here
          />
          <input
            type="text"
            placeholder="Player 2 Name"
            value={player2Name}
            onChange={(e) => setPlayer2Name(e.target.value)}
            className="text-center p-2 border border-black rounded-lg" // Add borders here
          />
        </div>
        <button onClick={fetchGreeting}>Click <b>here</b> to start the game</button>
        {greeting && <p>GET request result: {greeting}</p>}
      </div>

      <div className="card">
        <img src={chessboard} alt="Chessboard" className="mx-auto p-0.1 w-1/3" />
      </div>



      <div className="card">
        <button onClick={fetchGreeting}>Click <b>here</b> to make a move</button>
        <br />
        [input move to be implemented]
      </div>

      <div className="card">
        <img src={chessboardImage} alt="Chessboard" className="mx-auto p-4 w-1/2" />
      </div>
    </>
  );
}

export default App;
