import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'

function App() {
  const [count, setCount] = useState(0);
  const [greeting, setGreeting] = useState('');

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
        <button onClick={fetchGreeting}>Click <b>here</b> to start game</button>

        {greeting && <p>GET request result: {greeting}</p>}
      </div>

      <div className="card">
        <button onClick={fetchGreeting}>Click <b>here</b> to do a move </button>
        <br />
        [input move to be implemented]

      </div>

    </>
  )
}

export default App

