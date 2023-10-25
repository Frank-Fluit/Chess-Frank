import { useState, useEffect } from 'react';

const MatchHistory = () => {
  const [matchHistory, setMatchHistory] = useState([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    // Use the useEffect hook to fetch match history data when the component mounts
    getMatchHistory();
  }, []);

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
        const matchHistoryData = await response.json();
        setMatchHistory(matchHistoryData);
        setLoading(false); // Update the loading state
      } else {
        console.error(`HTTP error! Status: ${response.status}`);
      }
    } catch (error) {
      console.error('Fetch error:', error);
    }
  }

  return (
    <div>
      <h2>Leaderboard</h2>

      {loading ? (
        <p>Loading...</p>
      ) : (
        <ul>
          {matchHistory.map((match, index) => (
            <li key={index}>
              {/* Display the match history data here */}
              {match[0] + " " + match[1] }
            </li>
          ))}
        </ul>
      )}
    </div>
  );
};

export default MatchHistory;