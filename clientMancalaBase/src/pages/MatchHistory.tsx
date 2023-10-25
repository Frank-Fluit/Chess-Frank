import { useState, useEffect } from 'react';

import React from 'react';
import background from '../assets/AngryCat.jpg';

export const MatchHistory = () => {
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
        <style>
          {`
            body {
              background-image: url(${background});
              background-size: cover;
              background-repeat: no-repeat;
            }
          `}
        </style>
    <div className="max-w-lg mx-auto p-4 border rounded bg-gray-100 m-4">
      <h2 className="text-2xl mb-4">Uitslagen Schaak</h2>

      {loading ? (
        <p className="italic text-gray-600">Loading...</p>
      ) : (
        <div>
          <div className="flex">
            <div className="w-1/2 font-bold">Naam</div>
            <div className="w-1/2 font-bold text-right">Gewonnen Potjes</div>
          </div>
          {matchHistory.map((match, index) => (
            <div
              key={index}
              className="flex mb-2"
            >
              <div className="w-1/2">{match[0]}</div>
              <div className="w-1/2 text-right">{match[1]}</div>
            </div>
          ))}
        </div>
      )}
    </div>
    </div>
  );
};

export default MatchHistory;