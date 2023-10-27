import { Ihm } from "./classes/ihm.js";
import { Morpion } from "./classes/morpion.js";
import { input } from "./tools.js";

const morpion = new Morpion();
const ihm = new Ihm(morpion);

async function playGame() {
  while (true) {
    ihm.updateGameStatus(morpion.currentPlayer);
    const position = await input("Entrez la position (0-8) : ");
    if (
      isNaN(position) ||
      position < 0 ||
      position > 8 ||
      morpion.board[position] !== null
    ) {
      console.log("Position invalide. Réessayez.");
      continue;
    }
    morpion.makeMove(position);
    const winner = morpion.checkWin();
    if (winner) {
      ihm.updateGameStatus(`wins${winner}`);
      break;
    }
    if (morpion.checkDraw()) {
      ihm.updateGameStatus("draw");
      break;
    }
  }
}

playGame();
