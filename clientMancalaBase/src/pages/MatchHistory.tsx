import { useState } from 'react'


const MatchHistory = () => {

const [matchHistory, setMatchHistory] = useState([]);
const [loading, setLoading] = useState(true);

async function getMatchHistory() {
      try {
        const response = await fetch("api/gamehistory", {
          method: "GET",
          headers: {
            Accept: "application/json",
            "Content-Type": "application/json",
          },

        });

        if (response.ok) {
          const matchHistory = await response.json();
          setMatchHistory(matchHistory);
        } else {
          console.error(`HTTP error! Status: ${response.status}`);
        }
      } catch (error) {
        console.error('Fetch error:', error);
      }
    }

  return (
    <div>
      <h2>Match History</h2>




      {/* //TODO TODO TODO*/}

      {/* Add a fetch call to the MatchHistory here*/}
      {/* Parse the response of fetch call to show historic results*/}





    </div>
  );
}

export default MatchHistory;