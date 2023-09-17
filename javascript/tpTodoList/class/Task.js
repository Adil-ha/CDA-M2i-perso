export class Task {
  static id = 1;
  constructor(text) {
    this.id = Task.id++;
    this.text = text;
  }

  render() {
    let li = document.createElement("li");
    li.classList.add(
      "list-group-item",
      "d-flex",
      "justify-content-between",
      "align-items-center"
    );
    li.id = `${this.id}`;
    li.textContent = this.text;
    const deleteButton = document.createElement("button");
    deleteButton.classList.add("btn", "btn-danger", "btnDeleteTask");
    deleteButton.textContent = "Supprimer";
    li.appendChild(deleteButton);
    return li;
  }
}
