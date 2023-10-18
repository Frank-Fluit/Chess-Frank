//add typescript type annotation

function Bowl(gameState, handleBowlClick){
    return <div key={6} onClick={() => handleBowlClick(6)} className="col-span-1 bg-green-200">
{gameState?.players[0].pits[6].nrOfStones} </div>;
}
export default Bowl;