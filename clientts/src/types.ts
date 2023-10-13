export type Greeting = {
  squares: Square[][];
};

export type Square = {
  pieceEnum: string; // You can replace this with a more specific type if needed
};

export function isGameState(gameState: unknown): gameState is GameState {
  return (gameState as GameState).players !== undefined;
}
