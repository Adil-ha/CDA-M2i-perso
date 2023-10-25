export class Ihm {
  constructor(morpion) {
    this.Morpion = morpion;
  }

  updateGameStatus(status) {
    let statustext;
    switch (status) {
      case "O":
        statustext = "Au tour du joueur 2 (O)";
        break;
      case "X":
        statustext = "Au tour du joueur 1 (X)";
        break;
      case "winsX":
        statustext = "Le joueur 1 (X) a gagné!";
        break;
      case "winsO":
        statustext = "Le joueur 2 (O) a gagné!";
        break;
      case "draw":
        statustext = "Egalité! Personne ne gagne";
        break;
    }
    console.log(statustext);
    this.displayBoard();
  }

  displayBoard() {
    console.log("Grille du jeu :");

    const board = this.Morpion.board;
    for (let i = 0; i < 9; i += 3) {
      console.log(
        `${board[i] || " "} | ${board[i + 1] || " "} | ${board[i + 2] || " "}`
      );
      if (i < 6) {
        console.log("---------");
      }
    }
  }
}
