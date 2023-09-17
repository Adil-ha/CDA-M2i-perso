import { Task } from "./Task.js";
export class TaskList {
  constructor() {
    this.tasks = [];
  }

  addTask(text) {
    const task = new Task(text);
    this.tasks.push(task);
  }

  removeTask(id) {
    let index = this.tasks.findIndex((objet) => objet.id == id);
    this.tasks.splice(index, 1);
  }

  removeAllTask() {
    return (this.tasks = []);
  }

  renderTasks() {
    const ul = document.createElement("ul");
    ul.classList.add("list-group", "ul");
    for (const task of this.tasks) {
      const li = task.render();
      ul.appendChild(li);
    }
    return ul;
  }
}
