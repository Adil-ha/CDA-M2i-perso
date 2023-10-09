import TaskContext from './contexts/tasks.context';
import FormTask from './components/FormTask';
import DisplayTask from './components/DisplayTask';
import classes from './App.module.css'
import { useState } from 'react';

function App() {
  const [tasks, setTasks] = useState([])
  return (
    <div className="App">
      <TaskContext.Provider value={{tasks,setTasks}}>
      <div className={classes.container}>
          <h1 className={classes.h1}>Todo List</h1>
          <FormTask/>
          <p>Click 'In Progress' to finish the task and 'Delete' to remove it</p>
          <DisplayTask/>
      </div>
      </TaskContext.Provider>
    </div>
  );
}

export default App;
