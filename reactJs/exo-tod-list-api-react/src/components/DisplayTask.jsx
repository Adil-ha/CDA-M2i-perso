import classes from "./DisplayTask.module.css";
// import "bootstrap/dist/css/bootstrap.min.css";
import axios from "axios";
import { useEffect, useState, useContext } from "react";
import { useNavigate } from "react-router-dom";
import TasksContext from "../contexts/ContactContext";

const DisplayTask = () => {
  const { tasks, setTasks } = useContext(TasksContext);
  const navigate = useNavigate();
  // const [tasks, setTasks] = useState([]);
  useEffect(() => {
    axios
      .get("http://localhost:5000/tasks")
      .then((response) => {
        console.log(response.data);
        setTasks(response.data);
      })
      .catch((error) => {
        console.error("Erreur : ", error);
      });
  }, []);
  const deleteTask = (taskId) => {
    axios
      .delete(`http://localhost:5000/tasks/${taskId}`)
      .then(() => {
        console.log("tâche avec id " + taskId + " supprimer");
        const updatedTasks = tasks.filter((task) => task.id !== taskId);
        setTasks(updatedTasks);
      })
      .catch((error) => {
        console.error("Erreur : ", error);
      });
  };

  const updateTask = (taskId) => {
    navigate(`/?mode=edit&id=${taskId}`);
  };

  return (
    <ul className={classes.ul}>
      {tasks.map((task) => (
        <li className={classes.li} key={task.id}>
          <span>{task.name}</span>

          <button onClick={() => deleteTask(task.id)}>Supprimer</button>
          <button onClick={() => updateTask(task.id)}>Modifier</button>
        </li>
      ))}
    </ul>
  );
};

export default DisplayTask;
// return (

//   <ul className={classes.ul}>
//     {tasks.map((task) => (
//       <li className={classes.li} key={task.id}>
//         {task.name} (Deadline : {task.deadline})
//         <ButtonStatusTask task={task} updateTask={updateTask} />
//         {task.isCompleted && (
//           <button
//             type="button"
//             onClick={() => deleteTask(task.id)}
//             className="close"
//             className={classes.btnClose}
//             aria-label="Close"
//           >
//             <span aria-hidden="true">&times;</span>
//           </button>
//         )}
//       </li>
//     ))}
//   </ul>
// );
