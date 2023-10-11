import Task from "../models/Task";
import classes from "./FormTask.module.css";
import { useNavigate, useSearchParams } from "react-router-dom";
import { useRef, useState, useContext, useEffect } from "react";
import axios from "axios";
import TasksContext from "../contexts/ContactContext";

const FormTask = () => {
  const { tasks, setTasks } = useContext(TasksContext);

  const nameTaskRef = useRef();
  const deadlineTaskRef = useRef();

  const [searchParams] = useSearchParams();
  const monId = searchParams.get("id");
  const mode = searchParams.get("mode");

  const navigate = useNavigate();

  const [nameTask, setNameTask] = useState("");
  const [date, setDate] = useState("");

  const updateTask = () => {
    if (mode === "edit" && monId) {
      const taskToEdit = tasks.find((t) => t.id == monId);
      if (taskToEdit) {
        setNameTask(taskToEdit.name);
        setDate(taskToEdit.deadline);
      }
    }
  };

  useEffect(() => {
    updateTask();
  }, [mode, monId]);

  const submitFormHandler = (e) => {
    e.preventDefault();

    const nameTaskValue = nameTaskRef.current.value;
    const deadlineTaskValue = deadlineTaskRef.current.value;

    if (nameTaskValue.trim() === "" || deadlineTaskValue.trim() === "") {
      alert("Veuillez remplir tous les champs.");
      return;
    }

    const newTask = new Task(nameTaskValue, deadlineTaskValue);

    if (mode === "edit") {
      axios
        .put(`http://localhost:5000/tasks/${monId}`, newTask)
        .then((response) => {
          const updatedTasksList = tasks.map((task) => {
            if (task.id === monId) {
              return new Task(nameTaskValue, deadlineTaskValue);
            }
            return task;
          });

          setTasks(updatedTasksList);
          console.log("log", tasks);
        })
        .catch((error) => {
          console.error("Erreur : ", error);
        });

      navigate("/");
    } else {
      axios
        .post("http://localhost:5000/tasks", newTask)
        .then((response) => {
          console.log(response.data);
          setTasks([...tasks, newTask]);
        })
        .catch((error) => {
          console.error("Erreur : ", error);
        });
    }

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
          value={nameTask}
          onChange={(e) => setNameTask(e.target.value)}
        />
        <input
          className={classes.input}
          ref={deadlineTaskRef}
          type="date"
          id="deadline"
          placeholder="Dead line"
          value={date}
          onChange={(e) => setDate(e.target.value)}
        />
        <button className={classes.button} type="submit">
          {mode === "edit" ? "Edit Task" : "Add Task"}
        </button>
      </form>
    </>
  );
};

export default FormTask;
