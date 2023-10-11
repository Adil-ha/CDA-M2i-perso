class Task {
  constructor(name, deadline) {
    this.id = new Date().getTime();
    this.name = name;
    this.deadline = deadline;
  }
}

export default Task;
