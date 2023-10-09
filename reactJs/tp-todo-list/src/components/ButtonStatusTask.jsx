import { useState } from 'react';
import classes from './ButtonStatus.module.css'

const ButtonStatusTask = ({ task, updateTask }) => {
  const [completed, setCompleted] = useState(false);

  const toggleStatus = () => {
    setCompleted(!completed);

    updateTask(task.id, !completed);
  };

  return (
    <>
      <button className={classes.btnStatus} onClick={toggleStatus}>{completed ? 'Finish' : 'In progress'}</button>
    </>
  );
};

export default ButtonStatusTask;