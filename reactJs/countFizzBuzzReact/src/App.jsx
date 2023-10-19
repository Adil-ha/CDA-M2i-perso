import "./App.css";
import CountFizzBuzz from "./components/CountFizzBuzz";

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <CountFizzBuzz max="30" />
      </header>
    </div>
  );
}

export default App;
