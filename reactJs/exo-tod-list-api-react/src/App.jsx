import "./App.css";
import classes from "./App.module.css";
import FormTask from "./components/FormTask";
import DisplayTask from "./components/DisplayTask";
import TasksContext from "./contexts/ContactContext";
import { useState } from "react";

function App() {
  const [tasks, setTasks] = useState([]);
  return (
    <TasksContext.Provider value={{ tasks, setTasks }}>
      <div className="App">
        <div className="App">
          <div className={classes.container}>
            <h1 className={classes.h1}>Todo List</h1>
            <FormTask />
            <DisplayTask />
          </div>
        </div>
      </div>
    </TasksContext.Provider>
  );
}

export default App;
