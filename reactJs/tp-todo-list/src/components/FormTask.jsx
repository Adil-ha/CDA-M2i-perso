import TaskContext from "../contexts/tasks.context";
import Task from "../models/Task";
import classes from "./FormTask.module.css";
import { useContext, useRef } from "react";

const FormTask = () => {
  let context = useContext(TaskContext);
  const { setTasks } = context;

  const nameTaskRef = useRef();
  const deadlineTaskRef = useRef();

  const submitFormHandler = (e) => {
    e.preventDefault();

    const nameTask = nameTaskRef.current.value;
    const deadlineTask = deadlineTaskRef.current.value;

    if (nameTask.trim() === "" || deadlineTask.trim() === "") {
      alert("Veuillez remplir tous les champs.");
      return;
    }

    const newTask = new Task(nameTask, deadlineTask);

    setTasks((prevTasks) => [...prevTasks, newTask]);

    nameTaskRef.current.value = "";
    deadlineTaskRef.current.value = "";
  };

  return (
    <>
      <form className={classes.form} onSubmit={submitFormHandler}>
        <input
          className={classes.input}
          ref={nameTaskRef}
          type="text"
          id="item"
          placeholder="To do"
        />
        <input
          className={classes.input}
          ref={deadlineTaskRef}
          type="date"
          id="deadline"
          placeholder="Dead line"
        />
        <button className={classes.button} type="submit">
          Add task
        </button>
      </form>
    </>
  );
};

export default FormTask;
