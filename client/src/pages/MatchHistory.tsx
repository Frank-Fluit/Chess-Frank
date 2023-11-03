import { useState, useEffect } from 'react';

import React from 'react';
import background from '../assets/AngryCat.jpg';
import background2 from '../assets/pattern1.jpg';

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
              background-image: url(${background2});
              background-size: cover;
              background-repeat: no-repeat;
            }
          `}
        </style>
    <div className="max-w-2xl mx-auto p-4 border rounded bg-yellow-500 m-4">
      <h2 className="text-6xl mb-4 font-bold bg-yellow-500">Uitslagen Schaak</h2>

      {loading ? (
        <p className="italic text-gray-600">Loading...</p>
      ) : (
        <div>
          <div className="flex">
            <div className="w-1/2 font-bold text-4xl">Naam</div>
            <div className="w-1/2 font-bold text-4xl text-right">Gewonnen Potjes</div>
          </div>
          {matchHistory.map((match, index) => (
            <div
              key={index}
              className="flex mb-2"
            >
              <div className="w-1/2 text-2xl">{match[0]}</div>
              <div className="w-1/2 text-2xl text-right">{match[1]}</div>
            </div>
          ))}
        </div>
      )}
    </div>
    </div>
  );
};

export default MatchHistory;