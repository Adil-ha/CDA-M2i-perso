import { useContext } from 'react';
import TaskContext from '../contexts/tasks.context';
import ButtonStatusTask from './ButtonStatusTask';
import classes from './DisplayTask.module.css'
import 'bootstrap/dist/css/bootstrap.min.css';


const DisplayTask = () => {
  const context = useContext(TaskContext);
  const tasks = context.tasks;
  const setTasks = context.setTasks;

  const deleteTask = (taskId) => {
    const updatedTasks = tasks.filter((task) => task.id !== taskId);
    setTasks(updatedTasks);
  };

  const updateTask = (taskId, isCompleted) => {
    const updatedTasks = tasks.map((task) =>
      task.id === taskId ? { ...task, isCompleted } : task
    );
    setTasks(updatedTasks);
  };

  return (
    <ul className={classes.ul} >
      {tasks.map((task) => (
        <li className={classes.li} key={task.id}>
          {task.name} (Deadline : {task.deadline})
          <ButtonStatusTask task={task} updateTask={updateTask} />
          {task.isCompleted && (
           
            <button type="button" onClick={() => deleteTask(task.id)} className="close" className={classes.btnClose} aria-label="Close">
            <span aria-hidden="true">&times;</span>
          </button>
          )}
        </li>
      ))}
    </ul>
  );
};

export default DisplayTask;