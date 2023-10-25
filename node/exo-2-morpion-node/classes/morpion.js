export class Morpion {
  constructor() {
    this.board = new Array(9).fill(null);
    this.currentPlayer = "X";
    this.winningPatterns = [
      [0, 1, 2],
      [3, 4, 5],
      [6, 7, 8],
      [0, 3, 6],
      [1, 4, 7],
      [2, 5, 8],
      [0, 4, 8],
      [2, 4, 6],
    ];
    this.ihm = null; 
  }

  setIhm(ihm) {
    this.ihm = ihm
  }

  checkWin() {
    for (const [a, b, c] of this.winningPatterns) {
      if (
        this.board[a] &&
        this.board[a] === this.board[b] &&
        this.board[a] === this.board[c]
      ) {
        return this.board[a];
      }
    }
    return null;
  }

  checkDraw() {
    return this.board.every((square) => square !== null);
  }

  makeMove(position) {
    if (this.board[position] === null) {
      this.board[position] = this.currentPlayer;
      this.currentPlayer = this.currentPlayer === "X" ? "O" : "X";
    }
    if (this.ihm) {
      this.ihm.updateGameStatus(this.checkWin());
    }
  }
}
