import { useState } from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import TimeForm from "./components/TimeForm";
import Timer from "./components/Timer";

function App() {
  const [timers, setTimers] = useState([]);

  const timeTimer = (e) => {
    console.log(e.durationTimer);
    if (timers.length < 5) {
      setTimers([...timers, e]);
    } else {
      console.log("La limite de 5 timers a été atteinte.");
    }
  };
  console.log(timers);

  return (
    <div className="App">
      <div className="container">
        <div className="minuteur border-dark rounded w-60">
          <h1>Minuteur</h1>
          <div className="row">
            <div className="col-4">
              <form action="#"></form>
              <TimeForm timeForm={timeTimer} />
            </div>
            <div className="col-8">
              {timers.map((timer) => (
                <Timer key={timer.id} duration={timer.durationTimer} />
              ))}
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}

export default App;
