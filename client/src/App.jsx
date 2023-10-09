import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'

function App() {
  const [count, setCount] = useState(0);
  const [greeting, setGreeting] = useState('');

  const fetchGreeting = () => {

    fetch('/api/hello/')

      .then((response) => {

        if (!response.ok) {

          throw new Error('Network response was not ok');
        }
        console.log(response);


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
      <div>
        <a href="https://vitejs.dev" target="_blank">
          <img src={viteLogo} className="logo" alt="Vite logo" />
        </a>
        <a href="https://react.dev" target="_blank">
          <img src={reactLogo} className="logo react" alt="React logo" />
        </a>
      </div>
      <h1>Vite + React</h1>
      <div className="card">
        <button onClick={fetchGreeting}>Fetch Greeting</button>
        <p>
          Edit <code>src/App.jsx</code> and save to test HMR
        </p>
        {greeting && <p>Greeting from the server: {greeting}</p>}
      </div>
      <p className="read-the-docs">
        Click on the Vite and React logos to learn more
      </p>
    </>
  )
}

export default App
