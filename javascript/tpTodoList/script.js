import { TaskList } from "./class/TaskList.js";

let btnAddTask = document.querySelector(".btnAddTask");
const taskListContainer = document.querySelector("#task-list-container");

const taskList = new TaskList();

btnAddTask.addEventListener("click", (e) => {
  e.preventDefault();
  let inputTask = document.querySelector(".task").value;
  taskList.addTask(inputTask);
  console.log(taskList.tasks);
  taskListContainer.innerHTML = "";
  taskListContainer.appendChild(taskList.renderTasks());

  deleteTask();
});

function deleteTask() {
  let btnDeleteTask = document.querySelectorAll(".btnDeleteTask");
  document.querySelector(".task").value = "";
  btnDeleteTask.forEach((btnDelete) => {
    btnDelete.addEventListener("click", (e) => {
      let id = e.target.parentNode.id;
      taskList.removeTask(id);
      console.log(taskList.tasks);

      let ul = e.target.closest("ul");
      let li = document.getElementById(id);
      ul.removeChild(li);
    });
  });
}

let reset = document.querySelector(".reset");

reset.addEventListener("click", () => {
  // location.reload();
  // taskListContainer.innerHTML = "";
  TaskList.tasks = [];
  taskList.renderTasks();
});
